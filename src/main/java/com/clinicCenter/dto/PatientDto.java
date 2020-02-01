package com.clinicCenter.dto;

import com.clinicCenter.model.MedicalRecord;
import lombok.Data;

@Data
public class PatientDto {
    private Long id;
    private Long ssn;
    private String city;
    private String phone;
    private String email;
    private String address;
    private String country;
    private String lastName;
    private String firstName;
    private MedicalRecord medicalRecord;
}
