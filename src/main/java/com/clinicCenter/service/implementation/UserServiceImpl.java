package com.clinicCenter.service.implementation;

import com.clinicCenter.model.*;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

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
    public void changePassword(Long id) {
        userRepository.changedPassword(id);
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

    @Transactional
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
        return userRepository.getDoctors();
    }

    @Override
    public Collection<User> getSearchedDoctors(Long selectedOption, Long id) {
        return userRepository.getSearchedDoctors(selectedOption, id);
    }


    @Override
    public void saveDoctor(Doctor doctor) {
        userRepository.save(doctor);
    }

    @Override
    public void removeDoctor(Long id) {
        userRepository.deleteFromUserAuthority(id);
        userRepository.deleteFromDoctorExaminationType(id);
        userRepository.deleteById(id);
    }

    @Override
    public ArrayList<User> getDoctorsFromClinic(Long id) {
        return userRepository.getDoctorsFromClinic(id);
    }

    @Override
    public Collection<UserMapperTwo> getAvailableDoctors(Long adminId) {
        return null;
    }


    @Override
    public Collection<User> getDoctorsThatCanDoExam(Long selectedOption, Long id, String date) {
        return userRepository.getDoctorsThatCanDoExam(selectedOption, id, date);
    }

    @Override
    public Collection<User> getDoctorsThatCanDoExamWithoutSelected(Long selectedOption, Long id, String date, Long doctorId) {
        return userRepository.getDoctorsThatCanDoExamWithoutSelected(selectedOption, id, date, doctorId);
    }


}
