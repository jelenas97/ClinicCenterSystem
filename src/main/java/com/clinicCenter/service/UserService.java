package com.clinicCenter.service;

import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;

public interface UserService {

    User getById(Long id);

    int updateMedicalStaff(Long id, UserMapper user);

}
