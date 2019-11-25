package com.clinicCenter.service.implementation;

import com.clinicCenter.dto.ClinicAdministratorDto;
import com.clinicCenter.model.ClinicAdministrator;
import com.clinicCenter.model.Patient;
import com.clinicCenter.model.User;
import com.clinicCenter.model.UserMapper;
import com.clinicCenter.repository.UserRepository;
import com.clinicCenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @Override
    public void save(Patient patient) {
        userRepository.save(patient);

    }

    @Override
    public Set<ClinicAdministratorDto> getAllAdmins() {
        Set<String> strings = userRepository.getAllAdmins();
        Set<ClinicAdministratorDto> administratorDtos = new HashSet<>();
        for(String s : strings){
            String[] parts = s.split(",");
            String id = parts[0];
            String name = parts[1];
            String lastName = parts[2];

            ClinicAdministratorDto clinicAdministratorDto = new ClinicAdministratorDto(id,name,lastName);
            administratorDtos.add(clinicAdministratorDto);
        }

        return  administratorDtos;
    }


}
