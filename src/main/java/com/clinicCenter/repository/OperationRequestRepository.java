package com.clinicCenter.repository;

import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.model.OperationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Date;

@Repository
public interface OperationRequestRepository extends JpaRepository<OperationRequest, Long> {

    @Query(value = "SELECT * FROM db.operation_request orq WHERE orq.doctor_id = :doctorId AND orq.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<OperationRequest> getDoctorsOperationRequests(Long doctorId, Date date1, Date date2);
}
