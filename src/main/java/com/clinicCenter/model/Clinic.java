package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder
public class Clinic {
    private Long id;
    private String name;
    private String address;
    private String description;
    private int clinicAverageRating;
    //private Collection<Examination> availableExaminations;
    private Collection<User> clinicDoctors;
    //private Collection<Room> clinicRooms;
    //private Collection<Examination> allExaminationPrices;
    private Collection<User> clinicAdministrators;
}
