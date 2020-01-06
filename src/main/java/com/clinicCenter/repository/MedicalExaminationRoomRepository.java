package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MedicalExaminationRoomRepository extends JpaRepository<MedicalExaminationRoom,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE MedicalExaminationRoom r SET r.name = :name, r.number = :number WHERE r.id = :id")
    int updateRoom(Long id, String name, Integer number);

}
