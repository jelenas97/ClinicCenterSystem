package com.clinicCenter.converter;

import com.clinicCenter.dto.ClinicAdministratorDto;
import com.clinicCenter.model.ClinicAdministrator;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Component
public class ClinicAdminToClinicAdminDtoConverter implements Converter<ClinicAdministrator, ClinicAdministratorDto> {

    @Override
    public ClinicAdministratorDto convert(ClinicAdministrator clinicAdministrator) {
        return ClinicAdministratorDto.builder()
                    .id(clinicAdministrator.getId())
                    .firstName(clinicAdministrator.getFirstName())
                    .lastName(clinicAdministrator.getLastName())
                    .email(clinicAdministrator.getEmail())
                    .city(clinicAdministrator.getCity())
                    .address(clinicAdministrator.getAddress())
                    .country(clinicAdministrator.getCountry())
                    .clinicName(clinicAdministrator.getClinic().getName())
                    .build();
    }
}
