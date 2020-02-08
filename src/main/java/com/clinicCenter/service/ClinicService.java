package com.clinicCenter.service;

import com.clinicCenter.model.Clinic;

import java.util.Collection;

public interface ClinicService {
    void save(Clinic clinic);
    Collection<Clinic> getAllClinics();
    Clinic getById(Long id);

    void rateClinic(Long id, Integer number);

    Collection<Clinic> getSearchedClinics(Long typeName);

    Clinic findByName(String clinicName);

    Clinic getAdminsClinic(Long id);

    void updateClinic(Clinic clinic);

    Collection<Clinic> getSearchedClinicsTwo(Long typeName, Double clinicRating);

    Collection<Clinic> getSearchedClinicsThree(Long typeName, String clinicName);

    Collection<Clinic> getSearchedClinicsFour(Long typeName, String clinicName, Double clinicRating);
}
