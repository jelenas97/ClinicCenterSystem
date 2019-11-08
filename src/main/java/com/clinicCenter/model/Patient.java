package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Patient extends User {
    private Set<MedicalExamination> scheduledExaminations;
    private Set<Operation> scheduledOperations;
    private MedicalRecord medicalRecord;
    private Set<MedicalExamination> historyOfExamination;
    private Set<Operation> historyOfOperation;
}
