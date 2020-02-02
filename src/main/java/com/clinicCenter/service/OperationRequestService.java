package com.clinicCenter.service;

import com.clinicCenter.model.OperationRequest;

import java.util.Collection;

public interface OperationRequestService {
    void save(OperationRequest request);
    Collection<OperationRequest> getAllOperationRequests();

    OperationRequest getOperationRequestById(Long requestId);
}
