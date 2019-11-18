package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class MedicalRecord {
    private Long id;
    private Integer weight;
    private Double height;
    private String bloodType;
    private Double diopter;
    private Set<Medicament> medicamentAllergy;
    private Set<MedicalReport> illnessHistory;
    private Set<MedicalExamination> examinationHistory;
    private Set<Operation> operationHistory;
}
