package com.clinicCenter.service;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.OperationRequest;

import java.util.Date;
import java.util.Set;

public interface OperationService {
    void saveOperation(OperationRequest operationRequest, Date dd, Double price, Double discount, Long roomId, Long requestId, Set<Doctor> doctors);
}
