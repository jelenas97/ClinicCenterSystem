package com.clinicCenter.controller;

import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.service.ClinicCenterAdminService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicCenterAdminController {

    private final UserService userService;
    private final ClinicCenterAdminService clinicCenterAdminService;

    @GetMapping(value = "/clinicCenterAdmin/{id}")
    public User getById(@PathVariable Long id){
        return clinicCenterAdminService.getById(id);
    }

    @PutMapping("/clinicCenterAdmin")
    public int updateMedicalStaff( @RequestBody UserMapper user) {
        return userService.updateUser(user);
    }
}
