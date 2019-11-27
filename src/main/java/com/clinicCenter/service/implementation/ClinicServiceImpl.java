package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.repository.ClinicRepository;
import com.clinicCenter.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public void save(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    @Override
    public Collection<Clinic> getAllClinics() {
        return  clinicRepository.findAll();
    }


}
