package com.clinicCenter.service;

import com.clinicCenter.model.Clinic;

import java.util.Collection;

public interface ClinicService {
    void save(Clinic clinic);
    Collection<Clinic> getAllClinics();

    void rateClinic(Long id, Integer number);
}
