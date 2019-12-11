package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.model.RegistrationRequest;
import com.clinicCenter.service.MedicalExaminationTypeService;
import com.clinicCenter.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationTypeController {

    @Autowired
    private MedicalExaminationTypeService medicalExaminationTypeService;

    @GetMapping("/typesOfMedicalExam")
    public Set<MedicalExaminationType> getAll(){
        Set<MedicalExaminationType> types = medicalExaminationTypeService.getAll();
        return  types;
    }
}
