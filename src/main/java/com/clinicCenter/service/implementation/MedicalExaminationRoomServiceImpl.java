package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.repository.MedicalExaminationRoomRepository;
import com.clinicCenter.service.MedicalExaminationRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

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

    @Override
    public void save(MedicalExaminationRoom room) {
        this.medicalExaminationRoomRepository.save(room);
    }

    @Override
    public Set<MedicalExaminationRoom> getRooms(String name, Integer number) {
        return this.medicalExaminationRoomRepository.getSearched(name.toLowerCase(), number);
    }

    @Override
    public Set<MedicalExaminationRoom> getRoomsName(String name) {
        return this.medicalExaminationRoomRepository.getSearchedByName(name.toLowerCase());
    }

    @Override
    public Set<MedicalExaminationRoom> getClinicRooms(Long clinicAdminId) {
        return medicalExaminationRoomRepository.getClinicRooms(clinicAdminId);
    }

    @Override
    public List<MedicalExaminationRoom> getAvailableRooms(Long id, Date date) {
        return medicalExaminationRoomRepository.getAvailableRooms(id, date);
    }
}

