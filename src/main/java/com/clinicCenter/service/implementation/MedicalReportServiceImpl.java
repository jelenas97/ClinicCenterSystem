package com.clinicCenter.service.implementation;

import com.clinicCenter.dto.MedicalReportDto;
import com.clinicCenter.dto.PatientDto;
import com.clinicCenter.model.MedicalReport;
import com.clinicCenter.model.Patient;
import com.clinicCenter.repository.MedicalReportRepository;
import com.clinicCenter.service.MedicalReportService;
import com.clinicCenter.utils.MapperUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MedicalReportServiceImpl implements MedicalReportService {

    private final MedicalReportRepository medicalReportRepository;

    @Override
    public void save(MedicalReport medicalReport) {
        medicalReportRepository.save(medicalReport);
    }

    @Override
    public void update(MedicalReport medicalReport) {
        medicalReportRepository.updateMedicalReport(medicalReport.getId(), medicalReport.getReport(),
                                     medicalReport.getDiagnosisId(), medicalReport.getMedicamentId(),
                                     medicalReport.getTherapy());
    }

    @Override
    public MedicalReportDto getById(Long id) {
        MedicalReport medicalReport = medicalReportRepository.findById(id).get();
        MedicalReportDto medicalReportDto = new MedicalReportDto();
        medicalReportDto.setReport(medicalReport.getReport());
        medicalReportDto.setTherapy(medicalReport.getTherapy());
        medicalReportDto.setPatientId(medicalReport.getMedicalExamination().getPatient().getId());
        medicalReportDto.setDoctorId(medicalReport.getMedicalExamination().getDoctor().getId());

        if(medicalReport.getMedicament() != null) {
            medicalReportDto.setMedicamentId(medicalReport.getMedicament().getId());
        }

        if(medicalReport.getDiagnosis() != null) {
            medicalReportDto.setDiagnosisId(medicalReport.getDiagnosis().getId());
        }

        return medicalReportDto;
    }

    @Override
    public Set<MedicalReportDto> getAllByPatientId(Long id) {
        List<MedicalReport> medicalReports = medicalReportRepository.getAllByPatientId(id);
        Set<MedicalReportDto> medicalReportDtos = new HashSet<>();

        for(MedicalReport mr : medicalReports){
            MedicalReportDto medicalReportDto = new MedicalReportDto();
            medicalReportDto.setId(mr.getId());
            medicalReportDto.setReport(mr.getReport());

            if(mr.getDiagnosis() != null) {
                medicalReportDto.setDiagnosisId(mr.getDiagnosis().getId());
                medicalReportDto.setDiagnosis(mr.getDiagnosis().getName());
            }

            if(mr.getMedicament() != null) {
                medicalReportDto.setMedicamentId(mr.getMedicament().getId());
                medicalReportDto.setMedicament(mr.getMedicament().getName());

            }

            medicalReportDto.setPatientId(mr.getMedicalExamination().getPatient().getId());
            medicalReportDto.setDoctorId(mr.getMedicalExamination().getDoctor().getId());
            medicalReportDto.setTherapy(mr.getTherapy());
            medicalReportDto.setClinicName(mr.getMedicalExamination().getClinic().getName());
            medicalReportDto.setDateExam(mr.getMedicalExamination().getDate());
            medicalReportDto.setDoctorName(mr.getMedicalExamination().getDoctor().getFirstName() + " "
                                           + mr.getMedicalExamination().getDoctor().getLastName() );
            medicalReportDtos.add(medicalReportDto);
        }

        return medicalReportDtos;
    }
}
