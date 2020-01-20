package com.clinicCenter.service;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.UserMapperTwo;

import java.util.List;
import java.util.Set;

public interface DoctorService {

    void save(Doctor doctor);
    List<Doctor> getAll();
    Doctor getById(Long id);

    Set<UserMapperTwo> getDoctorsExtended(String firstName, String lastName, double rating, Integer typeId, Integer clinicId);
}
