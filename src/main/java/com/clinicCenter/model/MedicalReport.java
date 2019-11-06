package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MedicalReport {
    private Long id;
    private Recipe recipe;
    private Diagnosis diagnosis;
    private String examinationInfo;
}
