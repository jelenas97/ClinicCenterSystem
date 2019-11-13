package com.clinicCenter.service.implementation;

import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
}
