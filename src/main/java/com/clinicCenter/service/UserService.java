package com.clinicCenter.service;

import com.clinicCenter.dto.ClinicAdministratorDto;
import com.clinicCenter.model.ClinicAdministrator;
import com.clinicCenter.model.Patient;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;

import java.util.Set;

public interface UserService {

    User getById(Long id);
    int updateMedicalStaff(Long id, UserMapper user);
    void save(Patient patient);
    Set<ClinicAdministratorDto> getAllAdmins();
}
