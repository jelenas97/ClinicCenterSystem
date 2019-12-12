package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
//@Builder
@Entity
@AllArgsConstructor
public class Clinic {

    public Clinic() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String description;

    private Double clinicAverageRating = 0.0;

    @Column
    private Integer timesRated = 0;

    @ManyToOne
    @JoinColumn(name = "CCA_Id")
    //@JsonIgnore
    private ClinicCenterAdministrator administrator;

    @OneToMany
    //@JsonIgnore
    private Set<MedicalExaminationRequest> examinationRequests;

    @OneToMany(mappedBy = "clinic")
    //@JsonIgnoreProperties("clinic")
    @JsonIgnore
    private Set<Doctor> doctors;
}

