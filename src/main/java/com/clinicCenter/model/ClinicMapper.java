package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

//@Data
//@Builder
public interface ClinicMapper {
    Long getId();
    String getName();
    String getDescription();
    String getCity();
    String getAddress();
    Double getClinic_average_rating();
}
