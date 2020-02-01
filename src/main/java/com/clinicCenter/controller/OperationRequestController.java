package com.clinicCenter.controller;

import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.service.OperationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class OperationRequestController {

    @Autowired
    private OperationRequestService operationRequestService;

    @GetMapping("auth/getAllOperationRequests")
    public Collection<OperationRequest> getAllOperationRequests() {
        return operationRequestService.getAllOperationRequests();
    }
}
