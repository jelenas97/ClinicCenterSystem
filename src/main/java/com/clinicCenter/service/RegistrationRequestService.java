package com.clinicCenter.service;

import com.clinicCenter.model.RegistrationRequest;

import java.util.Set;

public interface RegistrationRequestService {
    void save(RegistrationRequest registrationRequest);
    Set<RegistrationRequest> getAll();
    RegistrationRequest getById(Long id);
}
