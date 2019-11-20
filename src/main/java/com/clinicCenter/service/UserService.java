package com.clinicCenter.service;

import com.clinicCenter.model.Patient;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;

public interface UserService {

    User getById(Long id);

    User getByEmail(String email);

    int updateMedicalStaff(Long id, UserMapper user);
    void save(Patient patient);
}
