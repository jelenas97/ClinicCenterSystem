package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Set;

@Data
//@Builder
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

    public Patient(String email, String password, String firstName, String lastName, String address, String city, String country, String phone, Long ssn) {
        this.setEmail(email);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setAddress(address);
        this.setCity(city);
        this.setCountry(country);
        this.setPhone(phone);
        this.setSsn(ssn);
    }
}
