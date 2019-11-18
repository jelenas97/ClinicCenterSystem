package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Recipe {
    private Long id;
    private Set<Medicament> medicaments;
    private Nurse nurse;
    private Doctor doctor;
    private String description;
}
