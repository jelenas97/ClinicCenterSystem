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

}
