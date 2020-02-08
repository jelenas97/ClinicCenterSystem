package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRequest;
import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.service.MedicalExaminationRequestService;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationRequestController {

    @Autowired
    private MedicalExaminationRequestService medicalExaminationRequestService;

    @Autowired
    private MedicalExaminationRoomService medicalExaminationRoomService;

    @Autowired
    private MedicalExaminationService medicalExaminationService;


    @PutMapping("auth/sendMedicalExamRequest/{typeId}/{date}/{clinicId}/{doctorId}/{patientId}/{selectedTerm}")
    public void sendMedicalExamRequest(@PathVariable Long typeId, @PathVariable Date date, @PathVariable Long clinicId,
                                       @PathVariable Long doctorId, @PathVariable Long patientId, @PathVariable String selectedTerm) {
        System.out.println(date);
        System.out.println(selectedTerm);
        String[] time = selectedTerm.split(":");
        String hours = time[0];
        String minutes = time[1];
        System.out.println(hours);
        System.out.println(minutes);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date d = cal.getTime();
        System.out.println(d);

        medicalExaminationRequestService.sendRequest(typeId, d, clinicId, doctorId, patientId);
    }

    @GetMapping("auth/getAllExaminationRequests/{adminId}")
    public Collection<MedicalExaminationRequest> getAllExaminationRequests(@PathVariable Long adminId) {
        return medicalExaminationRequestService.getAllExaminationRequests(adminId);
    }

    @GetMapping("getMedicalExaminationById/{requestId}")
    public MedicalExaminationRequest getMedicalExaminationRequestById(@PathVariable Long requestId) {
        return medicalExaminationRequestService.getById(requestId);
    }

    @Scheduled(cron = "59 59 23 * * ?")
    public void automaticSchedule() {
        System.out.println("Automatska fja pregledi");
        int numberOfAllRequests = medicalExaminationRequestService.getAllExamsRequests().size();

        for (int i = 0; i < numberOfAllRequests; i++) {
            List<MedicalExaminationRequest> allRequests = medicalExaminationRequestService.getAllExamsRequests();
            MedicalExaminationRequest oneRequest = allRequests.get(0);
            List<MedicalExaminationRoom> availableRooms = medicalExaminationRoomService.getAvailableRooms(oneRequest.getClinic().getId(), oneRequest.getDate());
            try {
                medicalExaminationService.saveExamination(oneRequest.getDate(), oneRequest.getPrice(), oneRequest.getDuration(), oneRequest.getDiscount(), availableRooms.get(0).getId(),
                        oneRequest.getClinic().getId(), oneRequest.getDoctor().getId(), oneRequest.getPatient().getId(), oneRequest.getType().getId(), oneRequest.getId(), false);

            } catch (IndexOutOfBoundsException ioobe) {
                List<MedicalExaminationRoom> availableRooms2;
                int addDays = 1;
                Date newDate;
                do {
                    Calendar c = Calendar.getInstance();
                    c.setTime(oneRequest.getDate());
                    c.add(Calendar.DATE, addDays);
                    newDate = c.getTime();
                    availableRooms2 = medicalExaminationRoomService.getAvailableRooms(oneRequest.getClinic().getId(), newDate);
                    addDays++;
                } while (availableRooms2.size() == 0);
                medicalExaminationService.saveExamination(newDate, oneRequest.getPrice(), oneRequest.getDuration(), oneRequest.getDiscount(), availableRooms2.get(0).getId(),
                        oneRequest.getClinic().getId(), oneRequest.getDoctor().getId(), oneRequest.getPatient().getId(), oneRequest.getType().getId(), oneRequest.getId(), false);

            }
        }
    }
}
