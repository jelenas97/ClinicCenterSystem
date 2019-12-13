package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Patient;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.model.UserMapperTwo;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
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
    public User getByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public int updateUser(UserMapper user) {
        return userRepository.updateUser(user.getEmail(),user.getFirstName(),user.getLastName(),user.getCountry(),user.getCity(),user.getAddress(), user.getPhone());
    }


    @Override
    public void save(Patient patient) {
        userRepository.save(patient);

    }

    @Override
    public Set<String> getAllAdmins() {
        return userRepository.getAllAdmins();
    }

    @Override
    public void activateUser(Long id) {
        User user = userRepository.findById(id).get();
        user.setEnabled(true);
        System.out.println("sad treba da je true : " + user.isEnabled());
        userRepository.activateUser(id);
    }

    @Override
    public void rateDoctor(Long id, Integer number) {
        System.out.println(number);
        User doctor = userRepository.findById(id).get();
        int timesRated = doctor.getTimesRated();
        Double averageRating = doctor.getAverageRating();
        double averageRating2 = (averageRating * timesRated + number) / (timesRated + 1);
        System.out.println(averageRating2);
        doctor.setAverageRating(averageRating2);
        doctor.setTimesRated(timesRated + 1);
        userRepository.updateRating(id, averageRating2, timesRated + 1);
    }

    @Override
    public ArrayList<User> getDoctors() {
        return this.userRepository.getDoctors();
    }

    @Override
    public Collection<UserMapperTwo> getSearchedDoctors(Long selectedOption, Long id) {
        return userRepository.getSearchedDoctors(selectedOption, id);
    }


}
