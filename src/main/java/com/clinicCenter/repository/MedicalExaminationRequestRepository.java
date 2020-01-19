package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface MedicalExaminationRequestRepository extends JpaRepository<MedicalExaminationRequest, Long> {

    @Query(value = "SELECT * FROM medical_examination_request dber WHERE dber.clinic_id in (SELECT u.clinic_id FROM users u WHERE u.id = :adminId)", nativeQuery = true)
    Collection<MedicalExaminationRequest> getRequestForClinic(Long adminId);
}
