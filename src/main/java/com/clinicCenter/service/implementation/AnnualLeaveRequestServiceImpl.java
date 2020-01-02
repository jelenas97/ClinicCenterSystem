package com.clinicCenter.service.implementation;

import com.clinicCenter.model.AnnualLeaveRequest;
import com.clinicCenter.repository.AnnualLeaveRequestRepository;
import com.clinicCenter.service.AnnualLeaveRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnualLeaveRequestServiceImpl implements AnnualLeaveRequestService {

    private final AnnualLeaveRequestRepository annualLeaveRequestRepository;

    @Override
    public void save(AnnualLeaveRequest annualLeaveRequest) {
        annualLeaveRequestRepository.save(annualLeaveRequest);
    }

    @Override
    public void delete(Long id) {
        AnnualLeaveRequest annualLeaveRequest = annualLeaveRequestRepository.findById(id).get();
        annualLeaveRequestRepository.delete(annualLeaveRequest);
    }

    @Override
    public List<AnnualLeaveRequest> getAllVacationRequests() {
        return annualLeaveRequestRepository.getAllVacationRequest();
    }

    @Override
    public List<AnnualLeaveRequest> getAllAbsenceRequests() {
        return annualLeaveRequestRepository.getAllAbsenceRequest();
    }



}
