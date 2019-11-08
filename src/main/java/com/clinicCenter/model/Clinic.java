package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class Clinic {
    private Long id;
    private String name;
    private String address;
    private String city;
    private String description;
    private Double clinicAverageRating;
    private Set<MedicalExamination> availableExaminations;
    private Set<Doctor> clinicDoctors;
    private Set<MedicalExaminationRoom> examinationRooms;
    private Set<OperationRoom> operationRooms;
    private Set<MedicalExamination> allExaminationPrices;
    private Set<ClinicAdministrator> clinicAdministrators;
}
