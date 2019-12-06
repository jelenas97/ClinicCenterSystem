package com.clinicCenter.repository;

import com.clinicCenter.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Clinic c SET c.clinicAverageRating = :averageRating, c.timesRated = :timesRated WHERE c.id = :id")
    void updateRating(Long id, Double averageRating, Integer timesRated);
}
