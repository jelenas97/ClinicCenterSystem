package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.print.Doc;
import java.util.Date;

@Data
@Builder
@Entity
public class MedicalExamination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /*
    private MedicalExaminationType type;
    private Doctor doctor;
    private Clinic clinic;
    private MedicalExaminationRoom room;

    private Date date;
    private Double duration;
    private Double price;
    private Double discount;*/
}
