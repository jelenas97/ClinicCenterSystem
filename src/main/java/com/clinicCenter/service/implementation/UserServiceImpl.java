package com.clinicCenter.service.implementation;

import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    public int updateMedicalStaff(Long id, UserMapper user) {
        return userRepository.updateMedicalStaff(id,user.getFirstName(),user.getLastName(),user.getCountry(),user.getCity(),user.getAddress(), user.getPhone());

    }
}
