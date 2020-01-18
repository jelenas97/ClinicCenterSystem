package com.clinicCenter.service;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.model.ClinicMapper;

import java.util.Collection;
import java.util.Set;

public interface ClinicService {
    void save(Clinic clinic);
    Collection<Clinic> getAllClinics();
    Clinic getById(Long id);

    void rateClinic(Long id, Integer number);

    Set<ClinicMapper> getSearchedClinics(Long typeName);

    Clinic findByName(String clinicName);

    Clinic getAdminsClinic(Long id);

    void updateClinic(Clinic clinic);

    Set<ClinicMapper> getSearchedClinicsTwo(Long typeName, Double clinicRating);

    Set<ClinicMapper> getSearchedClinicsThree(Long typeName, String clinicName);

    Set<ClinicMapper> getSearchedClinicsFour(Long typeName, String clinicName, Double clinicRating);
}
