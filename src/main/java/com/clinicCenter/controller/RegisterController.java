package com.clinicCenter.controller;

import com.clinicCenter.model.Medicament;
import com.clinicCenter.model.Patient;
import com.clinicCenter.model.RegistrationRequest;
import com.clinicCenter.model.User;
import com.clinicCenter.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @PostMapping("/registration")
    public void getUser(@RequestBody RegistrationRequest registrationRequest){
      registrationRequestService.save(registrationRequest);
    }
}
