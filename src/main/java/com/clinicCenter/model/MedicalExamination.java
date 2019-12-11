package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.print.Doc;
import java.util.Date;

@Data
@Builder
public class MedicalExamination {
    private Long id;

    private MedicalExaminationType type;
    private Doctor doctor;
    private Clinic clinic;
    private MedicalExaminationRoom room;

    private Date date;
    private Double duration;
    private Double price;
    private Double discount;
}
