package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
public class MedicalReport {

    public MedicalReport(){

    }

    @Column
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String report;

    @OneToOne
    @JsonIgnore
    private Diagnosis diagnosis;

    @OneToOne
    @JsonIgnore
    private Medicament medicament;

    @OneToOne
    @JsonIgnore
    private MedicalExamination medicalExamination;

    @Column
    private String therapy;

    @Transient
    private Long doctorId;

    @Transient
    private Long diagnosisId;

    @Transient
    private Long medicamentId;



}
