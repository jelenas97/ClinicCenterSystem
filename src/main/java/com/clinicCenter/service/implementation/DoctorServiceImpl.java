package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.UserMapperTwo;
import com.clinicCenter.repository.DoctorRepository;
import com.clinicCenter.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;

    @Override
    public void save(Doctor doctor) {
        doctorRepository.save(doctor);
    }

    @Override
    public List<Doctor> getAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor getById(Long id) {
        return doctorRepository.getOne(id);
    }

    @Override
    public Set<UserMapperTwo> getDoctorsExtended(String firstName, String lastName, double rating, Integer typeId, Integer clinicId) {
        return doctorRepository.getSearchedExtended(firstName.toLowerCase(),lastName.toLowerCase(),rating,typeId,clinicId);
    }
}
