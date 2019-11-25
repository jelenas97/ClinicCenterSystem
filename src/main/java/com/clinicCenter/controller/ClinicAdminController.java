package com.clinicCenter.controller;

import com.clinicCenter.model.ClinicAdministrator;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicAdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/getAll")
    public Set<String> getAllByType(){
        Set<String> admins = userService.getAllAdmins();
        for(String s : admins){
            System.out.println(s);
        }
        return userService.getAllAdmins();
    }
}
