package com.clinicCenter.service.implementation;

import com.clinicCenter.model.RegistrationRequest;
import com.clinicCenter.repository.RegistrationRequestRepository;
import com.clinicCenter.service.RegistrationRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RegistrationRequestServiceImpl implements RegistrationRequestService {

    @Autowired
    private RegistrationRequestRepository registrationRequestRepository;

    @Override
    public void save(RegistrationRequest registrationRequest) {
        registrationRequestRepository.save(registrationRequest);
    }

    @Override
    public Set<RegistrationRequest> getAll() {
        return registrationRequestRepository.getAll();
    }

    @Override
    public RegistrationRequest getById(Long id) {
        return registrationRequestRepository.findById(id).get();
    }


}
