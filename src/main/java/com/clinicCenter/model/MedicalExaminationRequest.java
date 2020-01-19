package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
public class MedicalExaminationRequest {

    public MedicalExaminationRequest(){

    }

    public MedicalExaminationRequest(MedicalExaminationType type, Date date, Clinic clinic, Doctor doctor, Patient patient){
        this.type = type;
        this.date = date;
        this.clinic = clinic;
        this.doctor = doctor;
        this.patient = patient;
        this.discount = 0.0;
        this.duration = 30.0;
        this.price = 1000.0;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Date date;

    @Column
    private Double duration;

    //@JsonIgnore
    @JoinColumn(name = "clinic_id")
    @ManyToOne(fetch = FetchType.EAGER)
    private Clinic clinic;


    @ManyToOne
    @JoinColumn(name = "patient_id")
    //@JsonIgnore
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    //@JsonIgnore
    private Doctor doctor;

    @Column
    private Double price;

    @ManyToOne
    @JoinColumn(name = "met_id")
    private MedicalExaminationType type;

    @Column
    private Double discount;

}
