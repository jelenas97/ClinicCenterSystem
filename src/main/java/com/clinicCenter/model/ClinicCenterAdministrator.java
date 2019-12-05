package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;
import javax.persistence.*;
import java.util.Set;

@Data
//@Builder
@Entity
@DiscriminatorValue("CCA")
public class ClinicCenterAdministrator extends User {

    public ClinicCenterAdministrator() {
        this.setEnabled(false);
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
    /*
    For clinic center administrator
    ako imamo klase za zahteve
    private Collection<RegisterRequest> registerRequests;
     */

    @OneToMany(mappedBy = "administrator")
    private Set<Clinic> clinics;
}
