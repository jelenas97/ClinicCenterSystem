package com.clinicCenter.service.implementation;

import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.repository.OperationRequestRepository;
import com.clinicCenter.service.OperationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class OperationRequestServiceImpl implements OperationRequestService {
    @Autowired
    private OperationRequestRepository operationRequestRepository;

    @Override
    public Collection<OperationRequest> getAllOperationRequests() {
        return operationRequestRepository.findAll();
    }

    @Override
    public OperationRequest getOperationRequestById(Long requestId) {
         return operationRequestRepository.findById(requestId).get();
    }

    @Override
    public void save(OperationRequest request) {
        operationRequestRepository.save(request);
    }
}
