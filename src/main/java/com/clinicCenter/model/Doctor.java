package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Doctor extends User {
    private Set<Patient> examinedPatients;
    private Set<Patient> allClinicPatients;
    private Long doctorAverageRating;
    private Clinic worksInClinic;
}
