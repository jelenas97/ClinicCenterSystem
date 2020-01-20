package com.clinicCenter.controller;

import com.clinicCenter.model.*;
import com.clinicCenter.service.AuthorityService;
import com.clinicCenter.service.ClinicService;
import com.clinicCenter.service.DoctorService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class DoctorController {

    private final DoctorService doctorService;
    private final ClinicService clinicService;
    private final PasswordEncoder passwordEncoder;
    private final AuthorityService authorityService;


    @PostMapping("/auth/addDoctor/{id}")
    public void addDoctor(@RequestBody Doctor doctor, @PathVariable Long id) {
        Clinic clinic = clinicService.getById(id);
        List<Authority> authorities = authorityService.findByName("ROLE_DOCTOR");
        doctor.setType("DO");
        doctor.setTimesRated(0);
        doctor.setEnabled(true);
        doctor.setClinic(clinic);
        doctor.setAverageRating(0.0);
        doctor.setAuthorities(authorities);
        doctor.setPassword(passwordEncoder.encode(doctor.getPassword()));
        doctorService.save(doctor);
    }

    @GetMapping("/getSearchedDoctorsExtended/search")
    @ResponseBody
    public Set<UserMapperTwo> getSearched(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName, @RequestParam(name = "rating") double rating, @RequestParam(name = "type") Integer typeId,
                                          @RequestParam(name = "clinic") Integer clinicId) {

        Set<UserMapperTwo> doctors = null;
        doctors = doctorService.getDoctorsExtended(firstName,lastName,rating,typeId,clinicId);

        return doctors;
    }

    @GetMapping("hasExam/{id}")
    public Boolean hasExam(@PathVariable Long id){
        Integer howMany = doctorService.hasExam(id);
        return howMany > 0;
    }

}
