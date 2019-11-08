package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Nurse extends User {
    //to be added
    private Clinic worksInClinic;
    private Set<Recipe> validatedRecipes;
    private Set<Patient> allClinicPatients;
}
