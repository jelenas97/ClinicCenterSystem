package com.clinicCenter.controller;

import com.clinicCenter.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationController {

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @PutMapping("auth/sendMedicalExamRequest/{typeId}/{date}/{clinicId}/{doctorId}")
    public void sendMedicalExamRequest(@PathVariable Long typeId, @PathVariable Date date, @PathVariable Long clinicId, @PathVariable Long doctorId){
        medicalExaminationService.sendRequest(typeId, date, clinicId, doctorId);
    }
}
