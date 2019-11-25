package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@Entity
@DiscriminatorValue("CA")
public class ClinicAdministrator extends User {

    /*
    For clinic administrator
    ako imamo klase za sve zahteve
    private Collection<ExaminationRequest> examinationRequests;
    private Collection<OperationRequest> operationRequests;
     */
}
