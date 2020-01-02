package com.clinicCenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@DiscriminatorValue("DO")
public class Doctor extends User {

    public Doctor() {
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

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<MedicalExaminationRequest> examinationRequests;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "doctor_examination_types", joinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "type_id", referencedColumnName = "id"))
    @JsonIgnore
    private Set<MedicalExaminationType> medicalExaminationTypes;

    @ManyToOne
    @JoinColumn(name = "clinic_id")
    @JsonIgnore
    private Clinic clinic;

    @JsonIgnore
    @OneToMany(mappedBy = "refDoctor")
    private  Set<AnnualLeaveRequest> annualLeaveRequest;
}
