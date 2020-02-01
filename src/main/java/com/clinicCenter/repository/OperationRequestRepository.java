package com.clinicCenter.repository;

import com.clinicCenter.model.OperationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperationRequestRepository extends JpaRepository<OperationRequest, Long> {
}
