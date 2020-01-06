package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.MedicalExaminationType;

import java.util.List;

public interface MedicalExaminationRoomService {
    List<MedicalExaminationRoom> getAll();

    void removeById(Long id);

    MedicalExaminationRoom getById(Long id);

    int updateRoom(MedicalExaminationRoom room);

    void save(MedicalExaminationRoom room);

}
