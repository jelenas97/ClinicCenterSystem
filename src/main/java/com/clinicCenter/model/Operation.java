package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
public class Operation {
    public Operation() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date date;

    @Column
    private Double duration;

    @Column
    private Double price;

    @Column
    private Double discount;

    @JoinColumn(name = "clinic_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Clinic clinic;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;


    public Operation(Date dd, Double price, Double discount, Double duration, OperationRoom operationRoom, Doctor doctor, Patient patient, Clinic clinic) {
        this.date = dd;
        this.price = price;
        this.discount = discount;
        this.duration = 30.0;
        this.doctor = doctor;
        this.patient = patient;
        this.clinic = clinic;
    }
}
