package com.clinicCenter.repository;

import com.clinicCenter.model.AnnualLeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnualLeaveRequestRepository extends JpaRepository<AnnualLeaveRequest,Long> {

    @Query( value = "from AnnualLeaveRequest as a where a.flag='vacation'")
    List<AnnualLeaveRequest> getAllVacationRequest();

    @Query("from AnnualLeaveRequest as a where a.flag='absence'")
    List<AnnualLeaveRequest> getAllAbsenceRequest();
}
