package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {

    @Query(value = "select * from db.medical_report mr where mr.medical_examination_id = " +
                    "(select me.id from db.medical_examination me where me.patient_id = :id)", nativeQuery = true)
    List<MedicalReport> getAllByPatientId(Long id);
}
