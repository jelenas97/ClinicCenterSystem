package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class MedicalExamination {
    private long id;
    private Date date;
    private double duration;
    private MedicalExaminationRoom room;
    private User doctor;
    private double price;
    private MedicalExaminationType type;
    private double discount;
}
