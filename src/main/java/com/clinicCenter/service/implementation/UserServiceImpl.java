package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Patient;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getById(Long id) {
        return userRepository.findById(id).get();
    }

    @Override
    public User getByEmail(String email) {return userRepository.findByEmail(email);}

    public int updateMedicalStaff(UserMapper user) {
        return userRepository.updateMedicalStaff(user.getEmail(),user.getFirstName(),user.getLastName(),user.getCountry(),user.getCity(),user.getAddress(), user.getPhone());

    }

    @Override
    public void save(Patient patient) {
        userRepository.save(patient);

    }

    @Override
    public Set<String> getAllAdmins() {
        return userRepository.getAllAdmins();
    }


}
