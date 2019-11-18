package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Data
@Builder
@Entity
@DiscriminatorValue("CCA")
public class ClinicCenterAdministrator extends User {
    /*
    For clinic center administrator
    ako imamo klase za zahteve
    private Collection<RegisterRequest> registerRequests;
     */
}
