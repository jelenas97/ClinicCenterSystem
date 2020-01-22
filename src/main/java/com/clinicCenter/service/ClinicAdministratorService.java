package com.clinicCenter.service;

import com.clinicCenter.dto.ClinicAdministratorDto;
import com.clinicCenter.model.ClinicAdministrator;

import java.util.Set;

public interface ClinicAdministratorService {
    void delete(Long id);
    Set<ClinicAdministratorDto> getAll();
    void save(ClinicAdministrator clinicAdministrator);
}
