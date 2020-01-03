package com.clinicCenter.service;

import com.clinicCenter.model.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public interface UserService {

    User getById(Long id);

    User getByEmail(String email);

    int updateUser(UserMapper user);

    void save(Patient patient);

    Set<String> getAllAdmins();

    void activateUser(Long id);

    void rateDoctor(Long id, Integer number);

    ArrayList<User> getDoctors();

    Collection<UserMapperTwo> getSearchedDoctors(Long selectedOption, Long id);

    void saveDoctor(Doctor doctor);

    void removeDoctor(Long id);

    ArrayList<User> getDoctorsFromClinic(Long id);
}


