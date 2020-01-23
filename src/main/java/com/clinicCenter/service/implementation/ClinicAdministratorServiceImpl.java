package com.clinicCenter.service.implementation;

import com.clinicCenter.converter.ClinicAdminToClinicAdminDtoConverter;
import com.clinicCenter.dto.ClinicAdministratorDto;
import com.clinicCenter.model.ClinicAdministrator;
import com.clinicCenter.repository.ClinicAdministratorRepository;
import com.clinicCenter.repository.ClinicRepository;
import com.clinicCenter.service.ClinicAdministratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ClinicAdministratorServiceImpl implements ClinicAdministratorService {

    private final ClinicAdministratorRepository clinicAdministratorRepository;
    private final ClinicAdminToClinicAdminDtoConverter clinicAdminToClinicAdminDtoConverter;


    @Override
    public void save(ClinicAdministrator clinicAdministrator) {
        clinicAdministratorRepository.save(clinicAdministrator);
    }

    @Override
    public void delete(Long id) {
        clinicAdministratorRepository.deleteById(id);
    }

    @Override
    public Set<ClinicAdministratorDto> getAll() {
        List<ClinicAdministrator> admins = clinicAdministratorRepository.findAll();
        Set<ClinicAdministratorDto> administratorDtos = new HashSet<>();

        for(ClinicAdministrator ca : admins){
            ClinicAdministratorDto caDto = clinicAdminToClinicAdminDtoConverter.convert(ca);
            administratorDtos.add(caDto);
        }

        return administratorDtos;
    }


}
