package com.clinicCenter.service;

import com.clinicCenter.model.AnnualLeaveRequest;

import java.util.List;

public interface AnnualLeaveRequestService {
    void save(AnnualLeaveRequest annualLeaveRequest);
    void delete(Long id);
    List<AnnualLeaveRequest> getAllVacationRequests();
    List<AnnualLeaveRequest> getAllAbsenceRequests();

}
