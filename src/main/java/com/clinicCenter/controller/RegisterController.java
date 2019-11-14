package com.clinicCenter.controller;

import com.clinicCenter.model.Medicament;
import com.clinicCenter.model.Patient;
import com.clinicCenter.model.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

    @PostMapping("/registration")
    public void getUser(@RequestBody Medicament medicament){
        System.out.println("USO");
    }
}
