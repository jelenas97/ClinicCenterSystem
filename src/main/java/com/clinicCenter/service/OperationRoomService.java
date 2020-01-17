package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRoom;

import java.util.List;
import java.util.Set;

public interface OperationRoomService {

    List<OperationRoom> getAll();

    void removeById(Long id);

    OperationRoom getById(Long id);

    int updateRoom(OperationRoom room);

    void save(OperationRoom room);

    Set<OperationRoom> getRooms(String name, Integer number);

    Set<OperationRoom> getRoomsName(String name);
}
