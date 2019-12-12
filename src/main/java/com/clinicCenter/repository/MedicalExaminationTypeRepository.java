package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.model.Medicament;
import com.clinicCenter.model.RegistrationRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface MedicalExaminationTypeRepository extends JpaRepository<MedicalExaminationType,Long> {
    @Query(value = "SELECT * from medical_examination_type", nativeQuery = true)
    Set<MedicalExaminationType> getAll();

    @Modifying
    @Transactional
    @Query("UPDATE MedicalExaminationType t SET t.name = :name, t.price = :price WHERE t.id = :id")
    int updateType(Long id, String name, Double price);
}
