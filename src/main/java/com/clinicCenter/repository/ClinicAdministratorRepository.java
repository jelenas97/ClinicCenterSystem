package com.clinicCenter.repository;

import com.clinicCenter.model.ClinicAdministrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicAdministratorRepository extends JpaRepository<ClinicAdministrator, Long> {
}
