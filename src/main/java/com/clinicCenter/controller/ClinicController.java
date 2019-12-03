package com.clinicCenter.controller;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.service.ClinicService;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping("/createClinic")
    public void saveClinic(@RequestBody Clinic clinic){
        clinicService.save(clinic);
    }

    @GetMapping("/auth/getAllClinics")
    public Collection<Clinic> getAllClinics() {System.out.println("klinike"); return clinicService.getAllClinics();}

    @PutMapping("/auth/rateClinic/{id}/{number}")
    public void rateClinis(@PathVariable Long id, @PathVariable Integer number){
        clinicService.rateClinic(id, number);
    }

}
