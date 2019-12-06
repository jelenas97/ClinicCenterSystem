package com.clinicCenter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class NurseController {

    @GetMapping("/auth/nurseHomePage/{id-}")
    public void nurseHomePage(){
        System.out.println("usla seka");
    }

}
