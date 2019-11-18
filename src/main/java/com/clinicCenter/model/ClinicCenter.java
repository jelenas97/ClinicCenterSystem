package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class ClinicCenter {
    private Long id;
    private String name;
    private Set<Clinic> clinics;
}
