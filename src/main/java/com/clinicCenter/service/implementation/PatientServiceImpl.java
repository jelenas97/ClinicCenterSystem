package com.clinicCenter.service.implementation;

import com.clinicCenter.dto.PatientDto;
import com.clinicCenter.model.Patient;
import com.clinicCenter.repository.PatientRepository;
import com.clinicCenter.service.PatientService;
import com.clinicCenter.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public void save(Patient patient) {
        patientRepository.save(patient);
    }

    @Override
    public Set<PatientDto> getAll() {
        List<Patient> patients = patientRepository.findAll();
        Set<PatientDto> patientDtos = patients.stream().map(p -> MapperUtils.map(p,PatientDto.class)).collect(Collectors.toSet());
        return  patientDtos;
    }

    @Override
    public ArrayList<Patient> getSearchedPatients(String firstName, String lastName) {
        return patientRepository.searchPatients(firstName.toLowerCase(), lastName.toLowerCase());
    }

    @Override
    public ArrayList<Patient> getSearchedPatients1(String firstName, String lastName, Long ssn) {
        return patientRepository.searchPatients1(firstName.toLowerCase(),lastName.toLowerCase(),ssn);
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).get();
    }
}
