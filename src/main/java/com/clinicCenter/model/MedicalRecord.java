package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class MedicalRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Integer weight;

    @Column
    private Double height;

    @Column
    private String bloodType;

    @Column
    private Double diopter;

    //private Set<Medicament> medicamentAllergy;
    //private Set<MedicalReport> illnessHistory;
    //private Set<MedicalExamination> examinationHistory;
    //private Set<Operation> operationHistory;
}
