package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Data
@Builder
@Entity
@DiscriminatorValue("NU")
public class Nurse extends User {
    //to be added
    /*private Clinic worksInClinic;
    private Set<Recipe> validatedRecipes;
    private Set<Patient> allClinicPatients;*/
}
