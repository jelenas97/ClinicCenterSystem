package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Data
@Builder
@Entity
@DiscriminatorValue("DO")
public class Doctor extends User {
    /*private Set<Patient> examinedPatients;
    private Set<Patient> allClinicPatients;
    private Long doctorAverageRating;
    private Clinic worksInClinic;*/
}
