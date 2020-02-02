package com.clinicCenter.controller;

import com.clinicCenter.model.*;
import com.clinicCenter.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalReportController {

    private final DoctorService doctorService;
    private final RecipeService recipeService;
    private final PatientService patientService;
    private final DiagnosisService diagnosisService;
    private final MedicamentService medicamentService;
    private final MedicalReportService medicalReportService;
    private final MedicalRecordHistoryService medicalRecordHistoryService;

    @PostMapping("/medicalReport")
    public void save(@RequestBody MedicalReport medicalReport){
        MedicalReport newMedicalReport = new MedicalReport();
        MedicalRecordHistory medicalRecordHistory = new MedicalRecordHistory();
        Diagnosis diagnosis = null;
        Medicament medicament = null;
        Doctor doctor = doctorService.getById(medicalReport.getDoctorId());

        if(medicalReport.getDiagnosisId() != null) {
            diagnosis = diagnosisService.getById(medicalReport.getDiagnosisId());
        }

        if(medicalReport.getMedicamentId() != null) {
            medicament = medicamentService.getById(medicalReport.getMedicamentId());
            Recipe recipe = new Recipe();
            recipe.setMedicament(medicament);
            recipe.setMedicamentName(medicament.getName());
            recipe.setDescription(medicalReport.getTherapy());
            recipe.setValidated(false);
            recipeService.save(recipe);

        }

        newMedicalReport.setDoctor(doctor);
        newMedicalReport.setDiagnosis(diagnosis);
        newMedicalReport.setMedicament(medicament);
        newMedicalReport.setReport(medicalReport.getReport());
        newMedicalReport.setTherapy(medicalReport.getTherapy());




        medicalReportService.save(newMedicalReport);
    }
}
