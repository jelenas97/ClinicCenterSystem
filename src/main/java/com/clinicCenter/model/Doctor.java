package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Data
@Builder
@Entity
@DiscriminatorValue("DO")
public class Doctor extends User {
    @Override
    public String getPassword() {
        return this.getPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    /*private Set<Patient> examinedPatients;
    private Set<Patient> allClinicPatients;
    private Long doctorAverageRating;
    private Clinic worksInClinic;*/
}
