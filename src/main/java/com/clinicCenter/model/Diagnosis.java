package com.clinicCenter.model;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Diagnosis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private Long code;

    @Column(nullable = false)
    private Long group;

    @Column(nullable = false)
    private String description;
}
