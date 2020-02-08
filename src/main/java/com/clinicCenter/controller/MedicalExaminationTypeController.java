package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import com.clinicCenter.model.RegistrationRequest;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.service.MedicalExaminationTypeService;
import com.clinicCenter.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalExaminationTypeController {

    @Autowired
    private MedicalExaminationTypeService medicalExaminationTypeService;

    @GetMapping("/typesOfMedicalExam")
    public List<MedicalExaminationType> getAll(){
        List<MedicalExaminationType> types = medicalExaminationTypeService.getAll();
        return types;
    }

    @DeleteMapping(value = "/typesOfMedicalExam/removeType/{id}")
    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    public void removeById(@PathVariable Long id) {
        this.medicalExaminationTypeService.removeById(id);
    }

    @PutMapping("/typesOfMedicalExam")
    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    public int updateTypeOfMedicalExam( @RequestBody MedicalExaminationType type) {
        return medicalExaminationTypeService.updateType(type);
    }

    @PostMapping("/typesOfMedicalExam")
    @PreAuthorize("hasRole('CLINIC_ADMIN')")
    public void addTypeOfMedicalExam(@RequestBody MedicalExaminationType type){
        medicalExaminationTypeService.save(type);
    }

    @GetMapping("/getAllMedicalExaminationTypes")
    public Collection<MedicalExaminationType> getAllMedicalExaminationTypes(){
        return medicalExaminationTypeService.getAllMedicalExaminationTypes();
    }
}
