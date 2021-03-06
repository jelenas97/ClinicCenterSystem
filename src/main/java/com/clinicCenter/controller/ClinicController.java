package com.clinicCenter.controller;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.service.ClinicService;
import com.clinicCenter.service.MedicalExaminationService;
import com.clinicCenter.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @Autowired
    private OperationService operationService;

    @PostMapping("/createClinic")
    public void saveClinic(@RequestBody Clinic clinic){
        clinicService.save(clinic);
    }

    @GetMapping("auth/getAllClinics")
    public Collection<Clinic> getAllClinics() { return clinicService.getAllClinics();}

    @PutMapping("/auth/rateClinic/{examId}/{number}/{clinicId}")
    @PreAuthorize("hasRole('PATIENT')")
    public void rateClinics(@PathVariable Long clinicId, @PathVariable Integer number, @PathVariable Long examId){
        clinicService.rateClinic(clinicId, number);
        medicalExaminationService.rateClinic(examId);
    }

    @PutMapping("/auth/rateClinicO/{examId}/{number}/{clinicId}")
    @PreAuthorize("hasRole('PATIENT')")
    public void rateClinicsO(@PathVariable Long clinicId, @PathVariable Integer number, @PathVariable Long examId){
        clinicService.rateClinic(clinicId, number);
        operationService.rateClinic(examId);
    }

    @GetMapping("auth/getSearchedClinics/{typeName}/{clinicName}/{clinicRating}")
    public Collection<Clinic> getSearchedClinics(@PathVariable Long typeName, @PathVariable String clinicName, @PathVariable Double clinicRating) {
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
