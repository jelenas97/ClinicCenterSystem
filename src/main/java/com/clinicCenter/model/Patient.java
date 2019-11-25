package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Data
@Builder
@Entity
@DiscriminatorValue("PA")
public class Patient extends User {
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
    /*private Set<MedicalExamination> scheduledExaminations;
    private Set<Operation> scheduledOperations;
    private MedicalRecord medicalRecord;
    private Set<MedicalExamination> historyOfExamination;
    private Set<Operation> historyOfOperation;*/
}
