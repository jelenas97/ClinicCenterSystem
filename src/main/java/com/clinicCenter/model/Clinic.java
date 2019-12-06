package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    public Clinic() {}

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

    @Column
    private Double clinicAverageRating = 0.0;

    @Column
    private Integer timesRated = 0;
   /*private Set<MedicalExamination> availableExaminations;
    private Set<Doctor> clinicDoctors;
    private Set<MedicalExaminationRoom> examinationRooms;
    private Set<OperationRoom> operationRooms;
    private Set<MedicalExamination> allExaminationPrices;
    private Set<ClinicAdministrator> clinicAdministrators;
    */

   @ManyToOne
   @JoinColumn(name = "CCA_Id")
   @JsonIgnore
   private ClinicCenterAdministrator administrator;
}

