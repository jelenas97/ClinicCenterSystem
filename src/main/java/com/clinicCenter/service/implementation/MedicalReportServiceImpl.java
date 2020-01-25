package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalReport;
import com.clinicCenter.repository.MedicalReportRepository;
import com.clinicCenter.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MedicalReportServiceImpl implements MedicalReportService {

    private final MedicalReportRepository medicalReportRepository;

    @Override
    public void save(MedicalReport medicalReport) {
        medicalReportRepository.save(medicalReport);
    }
}
