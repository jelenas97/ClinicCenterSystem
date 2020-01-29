package com.clinicCenter.service.implementation;

import com.clinicCenter.model.ClinicCenterAdministrator;
import com.clinicCenter.repository.ClinicCenterAdminRepository;
import com.clinicCenter.service.ClinicCenterAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClinicCenterAdminServiceImpl implements ClinicCenterAdminService {

    private final ClinicCenterAdminRepository clinicCenterAdminRepository;

    @Override
    public ClinicCenterAdministrator getById(Long id) {
        return clinicCenterAdminRepository.getOne(id);
    }

    @Override
    public void saveClinicCenterAdmin(ClinicCenterAdministrator clinicCenterAdministrator) {
        clinicCenterAdministrator.setPasswordChanged(false);
        clinicCenterAdminRepository.save(clinicCenterAdministrator);
    }
}
