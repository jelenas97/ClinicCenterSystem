package com.clinicCenter.controller;

import com.clinicCenter.model.RegistrationRequest;
import com.clinicCenter.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Set;
import java.util.function.LongFunction;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationRequestController {

    @Autowired
    private RegistrationRequestService registrationRequestService;

    @GetMapping("/registrationRequests")
    public Set<RegistrationRequest> getAll(){
        Set<RegistrationRequest> requests = registrationRequestService.getAll();
        return  requests;
    }

    @GetMapping(value = "/registrationRequest/{id}")
    public RegistrationRequest getById(@PathVariable Long id){
       RegistrationRequest rr = registrationRequestService.getById(id);
       return rr;
    }
}
