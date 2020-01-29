package com.clinicCenter.controller;

import com.clinicCenter.converter.ClinicAdminToClinicAdminDtoConverter;
import com.clinicCenter.dto.ClinicAdministratorDto;
import com.clinicCenter.model.*;
import com.clinicCenter.service.AuthorityService;
import com.clinicCenter.service.ClinicAdministratorService;
import com.clinicCenter.service.ClinicCenterAdminService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicAdminController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;
    private final ClinicAdministratorService clinicAdministratorService;
    private final ClinicCenterAdminService clinicCenterAdminService;

    @GetMapping("/getAllClinicAdmins")
    public Set<ClinicAdministratorDto> getAll(){
        return clinicAdministratorService.getAll();
    }

    @DeleteMapping(value = "/deleteClinicAdmin/{id}")
    public void deleteById(@PathVariable Long id){
        clinicAdministratorService.delete(id);
    }

    @GetMapping(value = "/clinicAdministrator/{id}")
    public User getById(@PathVariable Long id) {
        return userService.getById(id);
    }

    @PutMapping("/clinicAdministrator")
    public int updateMedicalStaff( @RequestBody UserMapper user) {
        return userService.updateUser(user);
    }

    @PostMapping("/addClinicAdmin/{clinic}")
    public void save(@RequestBody ClinicAdministrator clinicAdministrator, @PathVariable Clinic clinic){
        List<Authority> authorities = authorityService.findByName("ROLE_CLINIC_ADMIN");
        String passwordEnc = passwordEncoder.encode(clinicAdministrator.getPassword());

        clinicAdministrator.setPassword(passwordEnc);
        clinicAdministrator.setEnabled(true);
        clinicAdministrator.setClinic(clinic);
        clinicAdministrator.setAuthorities(authorities);
        clinicAdministratorService.save(clinicAdministrator);
    }

    @PostMapping("/addClinicCenterAdmin")
    public void save(@RequestBody ClinicCenterAdministrator clinicCenterAdministrator){
        List<Authority> authorities = authorityService.findByName("ROLE_CLINIC_CENTER_ADMIN");
        String passwordEnc = passwordEncoder.encode(clinicCenterAdministrator.getPassword());

        clinicCenterAdministrator.setPassword(passwordEnc);
        clinicCenterAdministrator.setEnabled(true);
        clinicCenterAdministrator.setAuthorities(authorities);
        clinicCenterAdminService.saveClinicCenterAdmin(clinicCenterAdministrator);
    }
}
