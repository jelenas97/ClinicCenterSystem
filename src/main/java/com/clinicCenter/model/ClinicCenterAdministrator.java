package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@DiscriminatorValue("CCA")
public class ClinicCenterAdministrator extends User {

    @OneToMany(mappedBy = "administrator")
    private Set<Clinic> clinics;
}
