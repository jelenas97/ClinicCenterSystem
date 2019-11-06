package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Diagnosis {
    private Long id;
    private String name;
    private String description;

}
