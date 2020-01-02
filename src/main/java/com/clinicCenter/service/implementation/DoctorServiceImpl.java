package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.repository.DoctorRepository;
import com.clinicCenter.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
