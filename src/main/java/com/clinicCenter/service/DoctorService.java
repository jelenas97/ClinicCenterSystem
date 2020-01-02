package com.clinicCenter.service;

import com.clinicCenter.model.Doctor;

import java.util.List;

public interface DoctorService {

    void save(Doctor doctor);
    List<Doctor> getAll();
    Doctor getById(Long id);
}
