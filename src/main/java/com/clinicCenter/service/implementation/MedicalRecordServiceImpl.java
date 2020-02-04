package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalRecord;
import com.clinicCenter.repository.MedicalRecordRepository;
import com.clinicCenter.service.MedicalRecordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalRecordServiceImpl implements MedicalRecordService {

    private final MedicalRecordRepository medicalRecordRepository;

    @Override
    public void save(MedicalRecord medicalRecord) {
         medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public MedicalRecord getById(Long id) {
        return medicalRecordRepository.getOne(id);
    }

    @Override
    public void update(MedicalRecord medicalRecord) {
        medicalRecordRepository.save(medicalRecord);
    }

    @Override
    public MedicalRecord getByPatientId(Long id) {
        return this.medicalRecordRepository.getByPatientId(id);
    }
}
