package com.clinicCenter.controller;

import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/medicalStaffProfile/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }

    @PutMapping("/medicalStaffProfile/{id}")
    public int updateMedicalStaff(@PathVariable Long id, @RequestBody UserMapper user) {
        return userService.updateMedicalStaff(id, user);
    }

    @PostMapping("/login")
    public void getUser(@RequestBody User user){
        System.out.println("loginovo sam se");
        userService.getByEmail(user.getEmail());
    }
}
