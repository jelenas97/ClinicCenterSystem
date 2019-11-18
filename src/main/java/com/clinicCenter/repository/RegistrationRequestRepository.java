package com.clinicCenter.repository;

import com.clinicCenter.model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface RegistrationRequestRepository extends JpaRepository<RegistrationRequest,Long> {

    @Query(value = "SELECT * from registration_request", nativeQuery = true)
    Set<RegistrationRequest> getAll();
}
