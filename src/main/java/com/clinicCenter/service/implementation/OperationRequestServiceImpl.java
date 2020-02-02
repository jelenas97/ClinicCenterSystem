package com.clinicCenter.service.implementation;

import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.repository.OperationRequestRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.service.OperationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OperationRequestServiceImpl implements OperationRequestService {
    @Autowired
    private OperationRequestRepository operationRequestRepository;

    @Override
    public void save(OperationRequest request) {
        operationRequestRepository.save(request);
    }
}
