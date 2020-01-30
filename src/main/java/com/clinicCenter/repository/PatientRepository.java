package com.clinicCenter.repository;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query(value = "SELECT * FROM db.users u WHERE lower(u.first_name) like %:firstName% and lower(u.last_name) like %:lastName% and u.type = 'PA'", nativeQuery = true)
    ArrayList<Patient> searchPatients(String firstName, String lastName);

    @Query(value = "SELECT * FROM db.users u WHERE lower(u.first_name) like %:firstName% and lower(u.last_name) like %:lastName% and u.ssn = :ssn and u.type = 'PA'", nativeQuery = true)
    ArrayList<Patient> searchPatients1(String firstName, String lastName, Long ssn);
}
