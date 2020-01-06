package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.repository.MedicalExaminationRoomRepository;
import com.clinicCenter.repository.MedicalExaminationTypeRepository;
import com.clinicCenter.service.MedicalExaminationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalExaminationRoomServiceImpl implements MedicalExaminationRoomService {

    @Autowired
    private MedicalExaminationRoomRepository medicalExaminationRoomRepository;

    @Override
    public List<MedicalExaminationRoom> getAll() {
        return this.medicalExaminationRoomRepository.findAll();
    }

    @Override
    public MedicalExaminationRoom getById(Long id) {
        return this.medicalExaminationRoomRepository.getOne(id);
    }

    @Override
    public void removeById(Long id) {
        this.medicalExaminationRoomRepository.deleteById(id);
    }

    @Override
    public int updateRoom(MedicalExaminationRoom room) {
        return this.medicalExaminationRoomRepository.updateRoom(room.getId(), room.getName(), room.getNumber());
    }
}
