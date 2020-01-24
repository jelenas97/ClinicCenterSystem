package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.MedicalExaminationRequest;
import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @Autowired
    private MedicalExaminationRoomService medicalExaminationRoomService;

    @PutMapping("auth/sendMedicalExamRequest/{typeId}/{date}/{clinicId}/{doctorId}/{patientId}")
    public void sendMedicalExamRequest(@PathVariable Long typeId, @PathVariable Date date, @PathVariable Long clinicId, @PathVariable Long doctorId, @PathVariable Long patientId) {
        medicalExaminationService.sendRequest(typeId, date, clinicId, doctorId, patientId);
    }

    @GetMapping("auth/getAllExaminationRequests/{adminId}")
    public Collection<MedicalExaminationRequest> getAllExaminationRequests(@PathVariable Long adminId) {
        return medicalExaminationService.getAllExaminationRequests(adminId);
    }

    @GetMapping("getMedicalExaminationById/{requestId}")
    public MedicalExaminationRequest getMedicalExaminationRequestById(@PathVariable Long requestId) {
        return medicalExaminationService.getById(requestId);
    }

    @PutMapping("saveExamination/{date}/{price}/{duration}/{discount}/{roomId}/{clinicId}/{doctorId}/{patientId}/{typeId}/{requestId}")
    public void saveExamination(@PathVariable String date, @PathVariable Double price, @PathVariable Double duration, @PathVariable Double discount,
                                @PathVariable Long roomId, @PathVariable Long clinicId, @PathVariable Long doctorId, @PathVariable Long patientId,
                                @PathVariable Long typeId, @PathVariable Long requestId) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = simpleDateFormat.parse(date);
        medicalExaminationService.saveExamination(d, price, duration, discount, roomId, clinicId, doctorId, patientId, typeId, requestId, false);
    }

    @PutMapping("/auth/confirmScheduledExamination/{id}")
    public void confirmScheduledExamination(@PathVariable Long id) {
        System.out.println("Potvrdjujem pregled");
        medicalExaminationService.confirmScheduledExamination(id);
    }

    @DeleteMapping("/auth/declineScheduledExamination/{id}")
    public void declineScheduledExamination(@PathVariable Long id) {
        System.out.println("Odbijam pregled");
        medicalExaminationService.declineScheduledExamination(id);
    }

    @Scheduled(cron = "59 59 23 * * ?")
    public void automaticSchedule() {
        System.out.println("Automatska fja");
        List<MedicalExaminationRequest> allRequests = medicalExaminationService.getAllExamsRequests();

        for (MedicalExaminationRequest r : allRequests) {
            List<MedicalExaminationRoom> availableRooms = medicalExaminationRoomService.getAvailableRooms(r.getClinic().getId(), r.getDate());
            try {
                medicalExaminationService.saveExamination(r.getDate(), r.getPrice(), r.getDuration(), r.getDiscount(), availableRooms.get(0).getId(),
                        r.getClinic().getId(), r.getDoctor().getId(), r.getPatient().getId(), r.getType().getId(), r.getId(), false);

            } catch (IndexOutOfBoundsException ioobe) {
                List<MedicalExaminationRoom> availableRooms2;
                int addDays = 1;
                Date newDate;
                do {
                    Calendar c = Calendar.getInstance();
                    c.setTime(r.getDate());
                    c.add(Calendar.DATE, addDays);
                    newDate = c.getTime();
                    availableRooms2 = medicalExaminationRoomService.getAvailableRooms(r.getClinic().getId(), newDate);
                    addDays++;
                } while (availableRooms2.size() == 0);
                medicalExaminationService.saveExamination(newDate, r.getPrice(), r.getDuration(), r.getDiscount(), availableRooms2.get(0).getId(),
                        r.getClinic().getId(), r.getDoctor().getId(), r.getPatient().getId(), r.getType().getId(), r.getId(), false);

            }
        }
    }


    @PostMapping("savePredefinedMedicalExamination/{date}/{typeId}/{duration}/{price}/{doctorId}/{clinicId}/{roomId}/{discount}")
    public void savePredefinedMedicalExamination(@PathVariable String date, @PathVariable Long typeId, @PathVariable Double duration, @PathVariable Double price,
                                                 @PathVariable Long doctorId, @PathVariable Long clinicId, @PathVariable Long roomId, @PathVariable Double discount) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = simpleDateFormat.parse(date);
        medicalExaminationService.saveExamination(d, price, duration, discount, roomId, clinicId, doctorId, null, typeId, null, true);
    }

    @GetMapping("getAllPredefinedExaminations")
    public Collection<MedicalExamination> getAllPredefinedMedicalExaminations() {
        return medicalExaminationService.getAllPredefinedMedicalExaminations();
    }

    @PutMapping("schedulePredefinedMedicalExamination/{examinationId}/{patientId}")
    public void schedulePredefinedMedicalExamination(@PathVariable Long examinationId, @PathVariable Long patientId) {
        medicalExaminationService.schedulePredefinedMedicalExamination(examinationId, patientId);
    }
}
