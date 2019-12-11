package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Data
//@Builder
@Entity
public class MedicalExaminationType {

    public MedicalExaminationType() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @OneToMany
    private Set<MedicalExaminationRequest> examinationRequests;
}
