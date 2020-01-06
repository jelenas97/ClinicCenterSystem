package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
public class MedicalExaminationRoom {

    public MedicalExaminationRoom() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer number;

    @OneToMany
    @JoinColumn(name = "mer_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<MedicalExamination> exams;

}
