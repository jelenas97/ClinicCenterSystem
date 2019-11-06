package com.clinicCenter.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String country;
    private String phone;
    private Long ssn;

    private Role role;

    /*
    For patient
    private Collection<Examination> scheduledExaminations;
    private MedicalRecord medicalRecord;
    private Collection<Examination> historyOfExamination;
    private Collection<Operation> historyOfOperation;
     */

    /*
    For medical staff
    private Collection<User> examinedPatients;
    private Collection<User> allClinicPatients;
    private Long doctorAverageRating;
    da li listu opercija  i pregleda ?
    radno vreme ?
     */

    /*
    For clinic administrator
    ako imamo klase za sve zahteve
    private Collection<ExaminationRequest> examinationRequests;
    private Collection<OperationRequest> operationRequests;
     */

    /*
    For clinic center administrator
    ako imamo klase za zahteve
    private Collection<RegisterRequest> registerRequests;
     */
}
