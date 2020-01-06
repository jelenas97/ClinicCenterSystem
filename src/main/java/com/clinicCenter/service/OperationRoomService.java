package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRoom;

import java.util.List;

public interface OperationRoomService {

    List<OperationRoom> getAll();

    void removeById(Long id);

    OperationRoom getById(Long id);

    int updateRoom(OperationRoom room);

    void save(OperationRoom room);

}
