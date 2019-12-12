package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExaminationType;

import java.util.Set;

public interface MedicalExaminationTypeService {
    Set<MedicalExaminationType> getAll();

    MedicalExaminationType getById(Long id);

    void removeById(Long id);
}
