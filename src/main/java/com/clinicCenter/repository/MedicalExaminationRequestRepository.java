package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationRequestRepository extends JpaRepository<MedicalExaminationRequest, Long> {
}
