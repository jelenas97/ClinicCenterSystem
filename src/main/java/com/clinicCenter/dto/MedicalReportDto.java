package com.clinicCenter.dto;

import com.clinicCenter.model.Diagnosis;
import com.clinicCenter.model.Medicament;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class MedicalReportDto {
    private Long id;
    private String report;
    private String therapy;
    private Date dateExam;
    private Long diagnosisId;
    private String diagnosis;
    private String clinicName;
    private String doctorName;
    private String medicament;
    private Long medicamentId;
    private Long doctorId;
    private Long patientId;
}
