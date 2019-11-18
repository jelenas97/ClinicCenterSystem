package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.print.Doc;
import java.util.Date;

@Data
@Builder
public class MedicalExamination {
    private Long id;
    private Date date;
    private Double duration;
    private MedicalExaminationRoom room;
    private Doctor doctor;
    private Double price;
    private MedicalExaminationType type;
    private Double discount;
}
