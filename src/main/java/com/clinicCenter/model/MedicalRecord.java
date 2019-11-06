package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class MedicalRecord {
    private Long id;
    private int weight;
    private double height;
    private String bloodType;
    private String medicamentAllergy;
    private Set<MedicalReport> illnessHistory;
}
