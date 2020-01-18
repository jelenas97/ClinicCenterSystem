package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
public interface MedicalExaminationRoomRepository extends JpaRepository<MedicalExaminationRoom,Long> {
    @Modifying
    @Transactional
    @Query("UPDATE MedicalExaminationRoom r SET r.name = :name, r.number = :number WHERE r.id = :id")
    int updateRoom(Long id, String name, Integer number);

    @Query(value = "SELECT * from db.medical_examination_room mer where lower(mer.name) like %:name% and mer.number = :number ", nativeQuery = true)
    Set<MedicalExaminationRoom> getSearched(String name, Integer number);

    @Query(value = "SELECT * from db.medical_examination_room mer where lower(mer.name) like %:name% ", nativeQuery = true)
    Set<MedicalExaminationRoom> getSearchedByName(String name);

    @Query(value = "SELECT * FROM db.medical_examination_room mer WHERE mer.clinic_id in (SELECT u.clinic_id FROM db.users u WHERE u.id = :clinicAdminId)", nativeQuery = true)
    Set<MedicalExaminationRoom> getClinicRooms(Long clinicAdminId);
}