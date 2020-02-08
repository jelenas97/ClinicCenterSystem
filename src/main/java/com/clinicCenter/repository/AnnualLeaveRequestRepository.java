package com.clinicCenter.repository;

import com.clinicCenter.model.AnnualLeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AnnualLeaveRequestRepository extends JpaRepository<AnnualLeaveRequest,Long> {

    @Query( value = "select * from db.annual_leave_request a where a.flag='vacation' and a.user_id in " +
            "(select u.id from db.users u where u.clinic_id = " +
            "(select uu.clinic_id from db.users uu where uu.id = :id))", nativeQuery = true)
    List<AnnualLeaveRequest> getAllVacationRequest(Long id);

    @Query(value = " select * from db.annual_leave_request as a where a.flag='absence' and a.user_id in " +
                    "(select u.id from db.users u where u.clinic_id = " +
                    "(select uu.clinic_id from db.users uu where uu.id = :id))" , nativeQuery = true)
    List<AnnualLeaveRequest> getAllAbsenceRequest(Long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE db.annual_leave_request alr SET alr.approved = TRUE WHERE alr.id = :id", nativeQuery = true)
    void approve(Long id);
}
