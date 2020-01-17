package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.Operation;
import com.clinicCenter.model.OperationRoom;
import com.clinicCenter.repository.MedicalExaminationRoomRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.service.OperationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class OperationRoomServiceImpl implements OperationRoomService {

    @Autowired
    private OperationRoomRepository operationRoomRepository;

    @Override
    public List<OperationRoom> getAll() {
        return this.operationRoomRepository.findAll();
    }

    @Override
    public void removeById(Long id) {
        this.operationRoomRepository.deleteById(id);
    }

    @Override
    public OperationRoom getById(Long id) {
        return this.operationRoomRepository.getOne(id);
    }

    @Override
    public int updateRoom(OperationRoom room) {
        return this.operationRoomRepository.updateRoom(room.getId(), room.getName(), room.getNumber());

    }

    @Override
    public void save(OperationRoom room) {
        this.operationRoomRepository.save(room);
    }

    @Override
    public Set<OperationRoom> getRooms(String name, Integer number) {
        return this.operationRoomRepository.getSearched(name.toLowerCase(), number);
    }

    @Override
    public Set<OperationRoom> getRoomsName(String name) {
        return this.operationRoomRepository.getSearchedByName(name.toLowerCase());
    }
}
