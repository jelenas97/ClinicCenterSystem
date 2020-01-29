package com.clinicCenter.controller;

import com.clinicCenter.model.*;
import com.clinicCenter.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalReportController {

    private final DoctorService doctorService;
    private final RecipeService recipeService;
    private final DiagnosisService diagnosisService;
    private final MedicamentService medicamentService;
    private final MedicalReportService medicalReportService;

    @PostMapping("/medicalReport")
    public void save(@RequestBody MedicalReport medicalReport){
        Doctor doctor = doctorService.getById(medicalReport.getDoctorId());
        Diagnosis diagnosis = diagnosisService.getById(medicalReport.getDiagnosisId());
        Medicament medicament = medicamentService.getById(medicalReport.getMedicamentId());

        medicalReport.setDoctor(doctor);
        medicalReport.setDiagnosis(diagnosis);
        medicalReport.setMedicament(medicament);

        Recipe recipe = new Recipe();
        recipe.setMedicament(medicament);
        recipe.setMedicamentName(medicament.getName());
        recipe.setDescription(medicalReport.getTherapy());
        recipe.setValidated(false);

        recipeService.save(recipe);
        medicalReportService.save(medicalReport);
    }
}
