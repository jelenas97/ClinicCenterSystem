package com.clinicCenter.controller;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.model.ClinicMapper;
import com.clinicCenter.service.ClinicService;
import com.clinicCenter.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private MedicalExaminationService medicalExaminationService;

    @PostMapping("/createClinic")
    public void saveClinic(@RequestBody Clinic clinic){
        clinicService.save(clinic);
    }

    @GetMapping("/auth/getAllClinics")
    public Collection<Clinic> getAllClinics() {System.out.println("klinike"); return clinicService.getAllClinics();}

    @PutMapping("/auth/rateClinic/{examId}/{number}/{clinicId}")
    public void rateClinics(@PathVariable Long clinicId, @PathVariable Integer number, @PathVariable Long examId){
        clinicService.rateClinic(clinicId, number);
        medicalExaminationService.rateClinic(examId);
    }

    @GetMapping("auth/getSearchedClinics/{typeName}/{clinicName}/{clinicRating}")
    public Set<ClinicMapper> getSearchedClinics(@PathVariable Long typeName, @PathVariable String clinicName, @PathVariable Double clinicRating) {
        System.out.println("Ovo je clinic name iz saercha " + clinicName);
        System.out.println("Ovo je rating clinice iz searcha " + clinicRating);
        if(clinicName.equals(" ") && clinicRating == 0.0){
            return clinicService.getSearchedClinics(typeName);
        } else if(clinicName.equals(" ")) {
            return clinicService.getSearchedClinicsTwo(typeName, clinicRating);
        } else if(clinicRating == 0.0){
            return clinicService.getSearchedClinicsThree(typeName, clinicName);
        } else {
            return clinicService.getSearchedClinicsFour(typeName, clinicName, clinicRating);
        }
    }

    @GetMapping("/auth/getAdminsClinic/{id}")
    public Clinic getAdminsClinic(@PathVariable Long id){
        return clinicService.getAdminsClinic(id);
    }

    @PutMapping("/auth/updateClinic")
    public void updateClinic(@RequestBody Clinic clinic){
        clinicService.updateClinic(clinic);
    }

}
