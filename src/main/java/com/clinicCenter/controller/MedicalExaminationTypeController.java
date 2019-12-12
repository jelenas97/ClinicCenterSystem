package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.model.RegistrationRequest;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.service.MedicalExaminationTypeService;
import com.clinicCenter.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationTypeController {

    @Autowired
    private MedicalExaminationTypeService medicalExaminationTypeService;

    @GetMapping("/typesOfMedicalExam")
    public Set<MedicalExaminationType> getAll(){
        Set<MedicalExaminationType> types = this.medicalExaminationTypeService.getAll();
        return  types;
    }

    @DeleteMapping(value = "/typesOfMedicalExam/removeType/{id}")
    public void removeById(@PathVariable Long id) {
        MedicalExaminationType type = this.medicalExaminationTypeService.getById(id);
        /*if(type.getExaminations().isEmpty())
        {
            kad se implementira sve
        }*/
        this.medicalExaminationTypeService.removeById(id);
    }

    @PutMapping("/typesOfMedicalExam")
    public int updateTypeOfMedicalExam( @RequestBody MedicalExaminationType type) {
        return medicalExaminationTypeService.updateType(type);
    }

}
