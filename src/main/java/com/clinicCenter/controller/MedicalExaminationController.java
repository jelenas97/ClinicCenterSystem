package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.MedicalExaminationRequest;
import com.clinicCenter.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @PutMapping("auth/sendMedicalExamRequest/{typeId}/{date}/{clinicId}/{doctorId}/{patientId}")
    public void sendMedicalExamRequest(@PathVariable Long typeId, @PathVariable Date date, @PathVariable Long clinicId, @PathVariable Long doctorId, @PathVariable Long patientId) {
        medicalExaminationService.sendRequest(typeId, date, clinicId, doctorId, patientId);
    }

    @GetMapping("auth/getAllExaminationRequests/{adminId}")
    public Collection<MedicalExaminationRequest> getAllExaminationRequests(@PathVariable Long adminId) {
        return medicalExaminationService.getAllExaminationRequests(adminId);
    }

    @GetMapping("getMedicalExaminationById/{requestId}")
    public MedicalExaminationRequest getMedicalExaminationRequestById(@PathVariable Long requestId){
        return medicalExaminationService.getById(requestId);
    }

    @PutMapping("saveExamination/{date}/{price}/{duration}/{discount}/{roomId}/{clinicId}/{doctorId}/{patientId}/{typeId}/{requestId}")
    public void saveExamination(@PathVariable String date, @PathVariable Double price, @PathVariable Double duration, @PathVariable Double discount,
                                @PathVariable Long roomId, @PathVariable Long clinicId, @PathVariable Long doctorId, @PathVariable Long patientId,
                                @PathVariable Long typeId, @PathVariable Long requestId) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d = simpleDateFormat.parse(date);
        medicalExaminationService.saveExamination(d, price, duration, discount, roomId, clinicId, doctorId, patientId, typeId, requestId);
    }

    @PutMapping("/auth/confirmScheduledExamination/{id}")
    public void confirmScheduledExamination(@PathVariable Long id){
        System.out.println("Potvrdjujem pregled");
        medicalExaminationService.confirmScheduledExamination(id);
    }

    @DeleteMapping("/auth/declineScheduledExamination/{id}")
    public void declineScheduledExamination(@PathVariable Long id){
        System.out.println("Odbijam pregled");
        medicalExaminationService.declineScheduledExamination(id);
    }

    @GetMapping("medicalExaminations/{roomId}")
    public Collection<MedicalExamination> getExaminationsFromRoom(@PathVariable Long roomId) {
        return medicalExaminationService.getAllExaminationsFromRoom(roomId);
    }
}
