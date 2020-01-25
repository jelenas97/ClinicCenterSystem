package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination SET confirmed = true WHERE id = :id", nativeQuery = true)
    void confirm(Long id);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.predefined = true and me.confirmed = false", nativeQuery = true)
    Collection<MedicalExamination> getAllPredefinedMedicalExaminations();

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination SET confirmed = true, patient_id = :patientId WHERE id = :examinationId", nativeQuery = true)
    void schedulePredefinedMedicalExamination(Long examinationId, Long patientId);

    @Query(value = "SELECT * FROM db.medical_examination me WHERE me.doctor_id = :id", nativeQuery = true)
    Collection<MedicalExamination> getAllFromDoctor(Long id);
}
