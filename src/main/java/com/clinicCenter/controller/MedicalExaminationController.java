package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRequest;
import com.clinicCenter.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
