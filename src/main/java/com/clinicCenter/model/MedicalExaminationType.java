package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class MedicalExaminationType {
    private long id;
    private String name;
    private Collection<MedicalExamination> exams;
}
