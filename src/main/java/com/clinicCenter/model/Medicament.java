package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Medicament {
    private Long id;
    private String name;
    private String purpose;
    private String description;
    private boolean onPrescription; //da li je na recept
}
