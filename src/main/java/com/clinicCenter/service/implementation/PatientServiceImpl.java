package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Patient;
import com.clinicCenter.repository.NurseRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.repository.PatientRepository;
import com.clinicCenter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public List<Patient> getAll() {
        return patientRepository.findAll();
    }

    @Override
    public ArrayList<Patient> getSearchedPatients(String firstName, String lastName) {
        return patientRepository.searchPatients(firstName.toLowerCase(), lastName.toLowerCase());
    }

    @Override
    public ArrayList<Patient> getSearchedPatients1(String firstName, String lastName, Long ssn) {
        return patientRepository.searchPatients1(firstName.toLowerCase(),lastName.toLowerCase(),ssn);
    }
}
