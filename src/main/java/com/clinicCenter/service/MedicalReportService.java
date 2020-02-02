package com.clinicCenter.service;

import com.clinicCenter.dto.MedicalReportDto;
import com.clinicCenter.model.MedicalReport;

import java.util.Set;

public interface MedicalReportService {
    void save(MedicalReport medicalReport);
    void update(MedicalReport medicalReport);
    MedicalReportDto getById(Long id);
    Set<MedicalReportDto> getAllByPatientId(Long id);
}
