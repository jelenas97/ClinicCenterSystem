package com.clinicCenter.service;

import com.clinicCenter.model.OperationRequest;

import java.util.Date;

public interface OperationService {
    void saveOperation(OperationRequest operationRequest, Date dd, Double price, Double discount, Long roomId, Long requestId);
}
