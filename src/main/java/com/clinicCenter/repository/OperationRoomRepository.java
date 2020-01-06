package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface OperationRoomRepository extends JpaRepository<OperationRoom,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE OperationRoom r SET r.name = :name, r.number = :number WHERE r.id = :id")
    int updateRoom(Long id, String name, Integer number);


}
