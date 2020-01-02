package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExamination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationRepository extends JpaRepository<MedicalExamination, Long> {
}
