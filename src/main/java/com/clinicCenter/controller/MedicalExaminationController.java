package com.clinicCenter.controller;

import com.clinicCenter.model.*;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationController {

    private final UserService userService;
    private final MedicalExaminationService medicalExaminationService;
    private final MedicalExaminationRoomService medicalExaminationRoomService;

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

        medicalExaminationService.sendRequest(typeId, d, clinicId, doctorId, patientId);
    }

    @GetMapping("auth/getAllExaminationRequests/{adminId}")
    public Collection<MedicalExaminationRequest> getAllExaminationRequests(@PathVariable Long adminId) {
        return medicalExaminationService.getAllExaminationRequests(adminId);
    }

    @GetMapping("getMedicalExaminationById/{requestId}")
    public MedicalExaminationRequest getMedicalExaminationRequestById(@PathVariable Long requestId) {
        return medicalExaminationService.getById(requestId);
    }

    @GetMapping("medicalExaminations/doctor/{id}")
    public Collection<MedicalExamination> getExaminationsFromRoomDoctor(@PathVariable Long id) {
        User user = userService.getById(id);
        Collection<MedicalExamination> list = medicalExaminationService.getAllExaminationsFromDoctor(id);
        return medicalExaminationService.getAllExaminationsFromDoctor(id);
    }

    @PutMapping("saveExamination/{date}/{price}/{duration}/{discount}/{roomId}/{clinicId}/{doctorId}/{patientId}/{typeId}/{requestId}/{selectedTerm}")
    public void saveExamination(@PathVariable String date, @PathVariable Double price, @PathVariable Double duration, @PathVariable Double discount,
                                @PathVariable Long roomId, @PathVariable Long clinicId, @PathVariable Long doctorId, @PathVariable Long patientId,
                                @PathVariable Long typeId, @PathVariable Long requestId, @PathVariable String selectedTerm) throws ParseException {
        date = date.replace('_', '-');
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = simpleDateFormat.parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        String[] time = selectedTerm.split(":");
        String hours = time[0];
        String minutes = time[1];

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dd = cal.getTime();


        medicalExaminationService.saveExamination(dd, price, duration, discount, roomId, clinicId, doctorId, patientId, typeId, requestId, false);
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

    @GetMapping("medicalExaminations/{roomId}")
    public Collection<MedicalExamination> getExaminationsFromRoom(@PathVariable Long roomId) {
        return medicalExaminationService.getAllExaminationsFromRoom(roomId);
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

    @GetMapping("getAllExaminationsPatientCanRate/{patientId}")
    public Collection<MedicalExamination> getAllExaminationsPatientCanRate(@PathVariable Long patientId) {
        return medicalExaminationService.getAllExaminationsPatientCanRate(patientId);
    }

    @GetMapping("getAvailableTermsForDoctor/{doctorId}/{date}")
    public Collection<String> getAvailableTermsForDoctor(@PathVariable Long doctorId, @PathVariable String date) throws ParseException {
        date = date.replace('_', '/');
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);

        Calendar c = Calendar.getInstance();
        c.setTime(date1);
        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        Date date2 = c.getTime();

        Doctor doctor = (Doctor) userService.getById(doctorId);
        Collection<MedicalExamination> examinationsForDoctor = medicalExaminationService.getDoctorsExaminationsByIdAndDate(doctorId, date1, date2);

        Collection<String> availableTerms = new ArrayList<String>();

        int startWork = doctor.getStartWork();
        int endWork = doctor.getEndWork();
        int iterations = (endWork - startWork);

        for (int i = startWork; i < endWork; i++) {
            for (int j = 0; j < 5; j += 3) {
                String part1 = "";
                if (i < 10) {
                    part1 = "0";
                } else {
                    part1 = "";
                }
                availableTerms.add(part1 + i + ":" + j + "0");
            }
        }

        System.out.println("Svi termini za ovog doktora su " + availableTerms);

        SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
        for (MedicalExamination examination : examinationsForDoctor) {
            String dateAndTime = formatter.format(examination.getDate());
            String time = dateAndTime.split(" ")[1].substring(0, 5);
            availableTerms.remove(time);
        }

        System.out.println("Svi slobodni termini za ovog doktora su" + availableTerms);

        return availableTerms;
    }

    @GetMapping("getMedicalExam/{examId}")
    public MedicalExamination getMedicalExam(@PathVariable Long examId) {
        return medicalExaminationService.getExamById(examId);
    }

    @GetMapping("getAvailableDoctorsForOperation/{date}/{term}/{clinicId}/{doctorId}")
    public Collection<User> getAvailableDoctorsForOperation(@PathVariable String date, @PathVariable String term,
                                                            @PathVariable Long clinicId, @PathVariable Long doctorId) throws ParseException {
        System.out.println(date);
        System.out.println(term);

        date = date.replace('_', '/');
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        System.out.println(date1);

        String[] time = term.split(":");
        String hours = time[0];
        String minutes = time[1];

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes) - 2);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dd = cal.getTime();
        System.out.println(dd);

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes) + 2);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date ddd = cal.getTime();
        System.out.println(ddd);

        return medicalExaminationService.getAvailableDoctorsForOperation(dd, ddd, clinicId, doctorId);
    }

}
