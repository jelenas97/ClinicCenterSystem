package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicalExaminationTypeRepository extends JpaRepository<MedicalExaminationType, Long> {
}
