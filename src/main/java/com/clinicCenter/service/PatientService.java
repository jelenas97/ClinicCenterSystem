package com.clinicCenter.service;

import com.clinicCenter.model.Patient;

import java.util.ArrayList;
import java.util.List;

public interface PatientService {
    List<Patient> getAll();

    ArrayList<Patient> getSearchedPatients(String firstName, String lastName);

    ArrayList<Patient> getSearchedPatients1(String firstName, String lastName, Long ssn);

    Patient getById(Long id);
}
