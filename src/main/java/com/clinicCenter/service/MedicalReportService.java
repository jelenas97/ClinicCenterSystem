package com.clinicCenter.service;

import com.clinicCenter.model.MedicalReport;

import java.util.List;

public interface MedicalReportService {
    void save(MedicalReport medicalReport);
    MedicalReport getById(Long id);
    List<MedicalReport> getAllByPatientId(Long id);
}
