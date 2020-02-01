package com.clinicCenter.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class OperationRequest {

    public OperationRequest() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer number;
}
