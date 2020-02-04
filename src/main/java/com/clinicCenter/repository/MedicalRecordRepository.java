package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalRecordRepository extends JpaRepository<MedicalRecord, Long> {
    @Query(value = "SELECT * from db.medical_record mr where mr.id = (select u.medical_record_id from db.users u where u.id = :id) ", nativeQuery = true)
    MedicalRecord getByPatientId(Long id);
}
