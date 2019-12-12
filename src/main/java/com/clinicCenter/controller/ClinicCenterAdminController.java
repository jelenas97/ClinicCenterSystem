package com.clinicCenter.controller;

import com.clinicCenter.model.User;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ClinicCenterAdminController {

    private final UserService userService;

    @GetMapping(value = "/auth/clinicCenterAdmin/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

}
