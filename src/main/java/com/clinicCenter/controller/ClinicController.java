package com.clinicCenter.controller;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.service.ClinicService;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicController {

    @Autowired
    private ClinicService clinicService;

    @PostMapping("/createClinic")
    public void saveClinic(@RequestBody Clinic clinic){
        clinicService.save(clinic);
    }

}