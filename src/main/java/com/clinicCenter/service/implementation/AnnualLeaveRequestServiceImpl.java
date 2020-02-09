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
    public AnnualLeaveRequest getById(Long id) {
        return annualLeaveRequestRepository.findById(id).get();
    }

    @Override
    public List<AnnualLeaveRequest> getAllVacationRequestsByAdminId(Long id) {
        return annualLeaveRequestRepository.getAllVacationRequest(id);
    }

    @Override
    public List<AnnualLeaveRequest> getAllAbsenceRequestsByAdminId(Long id) {
        return annualLeaveRequestRepository.getAllAbsenceRequest(id);
    }

    @Override
    public void approve(Long id) {
        AnnualLeaveRequest annualLeaveRequest = annualLeaveRequestRepository.findById(id).get();
        annualLeaveRequest.setApproved(true);
        annualLeaveRequestRepository.save(annualLeaveRequest);
    }
}
