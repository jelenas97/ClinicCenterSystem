package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface MedicalReportRepository extends JpaRepository<MedicalReport, Long> {

    @Query(value = "select * from db.medical_report mr where mr.medical_examination_id in " +
                    "(select me.id from db.medical_examination me where me.patient_id = :id)", nativeQuery = true)
    List<MedicalReport> getAllByPatientId(Long id);

    @Modifying
    @Transactional
    @Query(value = "update db.medical_report mr set mr.report = :report, mr.diagnosis_id = :diagnosis, mr.medicament_id = :medicament, mr.therapy = :therapy where mr.id = :id", nativeQuery = true)
    void updateMedicalReport(Long id, String report, Long diagnosis, Long medicament, String therapy);
}
