package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalReport;
import com.clinicCenter.repository.MedicalReportRepository;
import com.clinicCenter.service.MedicalReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicalReportServiceImpl implements MedicalReportService {

    private final MedicalReportRepository medicalReportRepository;

    @Override
    public void save(MedicalReport medicalReport) {
        medicalReportRepository.save(medicalReport);
    }

    @Override
    public MedicalReport getById(Long id) {
        return medicalReportRepository.findById(id).get();
    }

    @Override
    public List<MedicalReport> getAllByPatientId(Long id) {
        return null;
    }
}
