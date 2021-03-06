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


    public MedicalExaminationType(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
