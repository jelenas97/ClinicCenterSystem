package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class MedicalExaminationRoom {
    private long id;
    private String name;
    private int number;
    private Collection<MedicalExamination> exams;

}
