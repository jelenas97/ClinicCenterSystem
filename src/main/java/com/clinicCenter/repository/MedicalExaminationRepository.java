package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE db.medical_examination SET confirmed = true WHERE id = :id", nativeQuery = true)
    void confirm(Long id);

}
