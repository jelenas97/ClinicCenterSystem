package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ClinicAdministrator extends User {
    private Clinic clinic;
    /*
    For clinic administrator
    ako imamo klase za sve zahteve
    private Collection<ExaminationRequest> examinationRequests;
    private Collection<OperationRequest> operationRequests;
     */
}
