package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Data
//@Builder
@Entity
@DiscriminatorValue("PA")
public class Patient extends User {

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

    public Patient() {

    }

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
        this.setEnabled(false);
    }

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<MedicalExaminationRequest> examinationRequests;
}
