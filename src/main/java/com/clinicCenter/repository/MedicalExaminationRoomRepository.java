package com.clinicCenter.repository;

import com.clinicCenter.model.MedicalExaminationRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalExaminationRoomRepository extends JpaRepository<MedicalExaminationRoom,Long> {


}
