package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
@Entity
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String purpose;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private Boolean onPrescription; //da li je na recept
}
