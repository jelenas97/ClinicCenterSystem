package com.clinicCenter.controller;

import com.clinicCenter.dto.MedicalReportDto;
import com.clinicCenter.model.*;
import com.clinicCenter.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalReportController {

    private final RecipeService recipeService;
    private final DiagnosisService diagnosisService;
    private final MedicamentService medicamentService;
    private final MedicalReportService medicalReportService;
    private final MedicalExaminationService medicalExaminationService;

    @PostMapping("/medicalReport/{id}")
    public void save(@RequestBody MedicalReport medicalReport, @PathVariable Long id){
        MedicalReport newMedicalReport = new MedicalReport();
        Diagnosis diagnosis = null;
        Medicament medicament = null;

        MedicalExamination medicalExamination = medicalExaminationService.getExamById(id);

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

        newMedicalReport.setMedicalExamination(medicalExamination);
        newMedicalReport.setDiagnosis(diagnosis);
        newMedicalReport.setMedicament(medicament);
        newMedicalReport.setReport(medicalReport.getReport());
        newMedicalReport.setTherapy(medicalReport.getTherapy());

        medicalReportService.save(newMedicalReport);
        medicalExaminationService.finishExam(medicalExamination.getId());
    }

    @GetMapping("/editMedicalReport/{id}")
    public MedicalReportDto editById(@PathVariable Long id){
        MedicalReportDto medicalReport = medicalReportService.getById(id);
        return medicalReport;
    }

    @GetMapping("/medicalHistory/{id}")
    public Set<MedicalReportDto> getAll(@PathVariable Long id){
        Set<MedicalReportDto> medicalReports = medicalReportService.getAllByPatientId(id);
        return medicalReports;
    }

    @PutMapping("/saveEditedMedicalReport/{id}")
    public void saveEdited(@RequestBody MedicalReport medicalReport, @PathVariable Long id){
        medicalReport.setId(id);
        medicalReportService.update(medicalReport);
    }
}
