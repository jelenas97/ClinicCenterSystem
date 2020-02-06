package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.parameters.P;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@DiscriminatorValue("PA")
public class Patient extends User {

    @OneToOne
    private MedicalRecord medicalRecord;

    public Patient(String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
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

}
