package com.clinicCenter.service;

import com.clinicCenter.dto.PatientDto;
import com.clinicCenter.model.Patient;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface PatientService {

    void save(Patient patient);

    Set<PatientDto> getAll();

    ArrayList<Patient> getSearchedPatients(String firstName, String lastName);

    ArrayList<Patient> getSearchedPatients1(String firstName, String lastName, Long ssn);

    Patient getById(Long id);
}
