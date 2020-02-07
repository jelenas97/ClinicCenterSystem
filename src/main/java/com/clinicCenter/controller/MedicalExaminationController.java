package com.clinicCenter.controller;

import com.clinicCenter.model.*;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.JsonPath;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @GetMapping("medicalExaminations/doctor/{id}")
    public Collection<MedicalExamination> getExaminationsFromRoomDoctor(@PathVariable Long id) {
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
        medicalExaminationService.confirmScheduledExamination(id);
    }

    @DeleteMapping("/auth/declineScheduledExamination/{id}")
    public void declineScheduledExamination(@PathVariable Long id) {
        medicalExaminationService.declineScheduledExamination(id);
    }

    @GetMapping("medicalExaminations/{roomId}")
    public Collection<MedicalExamination> getExaminationsFromRoom(@PathVariable Long roomId) {
        return medicalExaminationService.getAllExaminationsFromRoom(roomId);
    }




    @PostMapping("savePredefinedMedicalExamination/{date}/{typeId}/{duration}/{price}/{doctorId}/{roomId}/{discount}/{term}/{clinicId}")
    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    public void savePredefinedMedicalExamination(@PathVariable String date, @PathVariable Long typeId, @PathVariable Double duration, @PathVariable Double price,
                                                 @PathVariable Long doctorId, @PathVariable Long roomId, @PathVariable Double discount, @PathVariable String term,
                                                 @PathVariable Long clinicId) throws ParseException {
        date = date.replace('_', '/');
        Date date1 = new SimpleDateFormat("yyyy/MM/dd").parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(date1);
        System.out.println(date1);

        String[] time = term.split(":");
        String hours = time[0];
        String minutes = time[1];

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dd = cal.getTime();
        medicalExaminationService.saveExamination(dd, price, duration, discount, roomId, clinicId, doctorId, null, typeId, null, true);
    }

    @GetMapping("getAllPredefinedExaminations")
    public Collection<MedicalExamination> getAllPredefinedMedicalExaminations() {
        return medicalExaminationService.getAllPredefinedMedicalExaminations();
    }

    @PutMapping("schedulePredefinedMedicalExamination/{examinationId}/{patientId}")
    @PreAuthorize("hasRole('PATIENT')")
    public void schedulePredefinedMedicalExamination(@PathVariable Long examinationId, @PathVariable Long patientId) {
        medicalExaminationService.schedulePredefinedMedicalExamination(examinationId, patientId);
    }

    @GetMapping("getAllExaminationsPatientCanRate/{patientId}")
    public Collection<MedicalExamination> getAllExaminationsPatientCanRate(@PathVariable Long patientId) {
        Collection<MedicalExamination> medicalExaminations = medicalExaminationService.getAllExaminationsPatientCanRate(patientId);
        return medicalExaminationService.getAllExaminationsPatientCanRate(patientId);
    }

    @GetMapping("getAvailableTermsForDoctor/{doctorId}/{date}")
    public Collection<String> getAvailableTermsForDoctor(@PathVariable Long doctorId, @PathVariable String date) throws ParseException {
        return medicalExaminationService.getAvailableTermsForDoctor(doctorId, date);
    }

    @GetMapping("getAvailableTermsForDoctorWithoutRequest/{doctorId}/{date}/{requestId}")
    public Collection<String> getAvailableTermsForDoctorWithoutRequest(@PathVariable Long doctorId, @PathVariable String date,
                                                                       @PathVariable Long requestId) throws ParseException {
        return medicalExaminationService.getAvailableTermsForDoctorWithoutRequest(doctorId, date, requestId);
    }

    @GetMapping("medicalExaminationsDaily/{id}")
    public List<Integer> getExaminationsFromClinicDaily(@PathVariable Long id) {
        List<Integer> list = medicalExaminationService.getAllExaminationsDaily(id);
        return list;
    }

    @GetMapping("medicalExaminationsMonthly/{id}")
    public List<Integer> getExaminationsFromClinicMonthly(@PathVariable Long id) {
        List<Integer> list = medicalExaminationService.getAllExaminationsMonthly(id);
        return list;
    }

    @GetMapping("medicalExaminationsYearly/{id}")
    public List<Integer> getExaminationsFromClinicYearly(@PathVariable Long id) {
        List<Integer> list = medicalExaminationService.getAllExaminationsYearly(id);
        return list;
    }

    @GetMapping("getClinicIncomes/{id}")
    public List<Long> getIncomes(@PathVariable Long id) {
        return medicalExaminationService.getIncomes(id);
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

    @GetMapping("canStartExam/{patientId}/{doctorId}")
    public Boolean canStartExam(@PathVariable Long patientId, @PathVariable Long doctorId) {
        return medicalExaminationService.canStartExam(patientId, doctorId);
    }

    @GetMapping("pastExam/{patientId}/{doctorId}")
    public Boolean pastExam(@PathVariable Long patientId, @PathVariable Long doctorId) {
        return medicalExaminationService.pastExam(patientId, doctorId);
    }


    @GetMapping("nurseAndPatient/{patientId}/{nurseId}")
    public Boolean nurseAndPatient(@PathVariable Long patientId, @PathVariable Long nurseId) {
        return medicalExaminationService.nurseAndPatient(patientId, nurseId);
    }

    @GetMapping("medicalExamPatientDoctor/{patientId}/{doctorId}")
    public MedicalExamination examDoctorPatient(@PathVariable Long patientId, @PathVariable Long doctorId) {
        return medicalExaminationService.examDoctorPatient(patientId, doctorId);
    }

    @GetMapping("getClinicsPredefinedExaminations/{clinicId}")
    public Collection<MedicalExamination> getClinicsPredefinedExaminations(@PathVariable Long clinicId) {
        return medicalExaminationService.getClinicsPredefinedExaminations(clinicId);
    }
}
