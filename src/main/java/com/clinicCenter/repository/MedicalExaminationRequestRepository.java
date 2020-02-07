package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Date;

public interface MedicalExaminationRequestRepository extends JpaRepository<MedicalExaminationRequest, Long> {

    @Query(value = "SELECT * FROM medical_examination_request dber WHERE dber.clinic_id in (SELECT u.clinic_id FROM users u WHERE u.id = :adminId)", nativeQuery = true)
    Collection<MedicalExaminationRequest> getRequestsForClinic(Long adminId);

    @Query(value = "SELECT * FROM db.medical_examination_request mer WHERE mer.doctor_id = :doctorId AND mer.date BETWEEN :date1 AND :date2", nativeQuery = true)
    Collection<MedicalExaminationRequest> getDoctorsExaminationRequestsByIdAndDate(Long doctorId, Date date1, Date date2);
}
