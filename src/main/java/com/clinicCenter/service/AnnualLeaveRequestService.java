package com.clinicCenter.service;

import com.clinicCenter.model.AnnualLeaveRequest;

import java.util.List;

public interface AnnualLeaveRequestService {
    void delete(Long id);
    AnnualLeaveRequest getById(Long id);
    void save(AnnualLeaveRequest annualLeaveRequest);
    List<AnnualLeaveRequest> getAllVacationRequestsByAdminId(Long id);
    List<AnnualLeaveRequest> getAllAbsenceRequestsByAdminId(Long id);

    void approve(Long id);
}
