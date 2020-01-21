package com.clinicCenter.repository;

import com.clinicCenter.model.ClinicCenterAdministrator;
import jdk.jfr.Registered;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicCenterAdminRepository extends JpaRepository<ClinicCenterAdministrator, Long> {
}
