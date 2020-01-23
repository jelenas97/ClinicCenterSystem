package com.clinicCenter.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClinicAdministratorDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String address;
    private String city;
    private String country;
    private String clinicName;
}
