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
    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
    /*
    For clinic center administrator
    ako imamo klase za zahteve
    private Collection<RegisterRequest> registerRequests;
     */
}
