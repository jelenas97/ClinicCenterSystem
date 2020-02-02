package com.clinicCenter.service;

import com.clinicCenter.model.MedicalRecord;

public interface MedicalRecordService {
    void save(MedicalRecord medicalRecord);
    MedicalRecord getById(Long id);

    void update(MedicalRecord medicalRecord);
}
