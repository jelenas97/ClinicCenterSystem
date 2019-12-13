package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationTypeController {

    @Autowired
    private MedicalExaminationTypeService medicalExaminationTypeService;

    @GetMapping("/getAllMedicalExaminationTypes")
    public Collection<MedicalExaminationType> getAllMedicalExaminationTypes(){
        return medicalExaminationTypeService.getAllMedicalExaminationTypes();
    }
}
