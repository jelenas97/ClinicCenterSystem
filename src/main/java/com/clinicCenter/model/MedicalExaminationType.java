package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.print.Doc;
import java.util.Collection;
import java.util.Set;

@Data
@Entity
public class MedicalExaminationType {

    public MedicalExaminationType() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @OneToMany
    @JoinColumn(name = "met_id", referencedColumnName = "id")
    @JsonIgnore
    private Set<MedicalExaminationRequest> examinationRequests;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(mappedBy = "medicalExaminationTypes")
    @JsonIgnore
    private Set<Doctor> doctors;

}
