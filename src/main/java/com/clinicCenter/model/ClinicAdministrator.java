package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@Entity
@DiscriminatorValue("CA")
public class ClinicAdministrator extends User {

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

    //@ManyToOne
    //@JoinColumn(name = "clinic_id")
    //private Clinic clinic;
    /*
    For clinic administrator
    ako imamo klase za sve zahteve
    private Collection<ExaminationRequest> examinationRequests;
    private Collection<OperationRequest> operationRequests;
     */
}
