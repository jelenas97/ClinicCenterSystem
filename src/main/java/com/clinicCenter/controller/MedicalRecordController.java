package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalRecord;
import com.clinicCenter.model.Patient;
import com.clinicCenter.service.MedicalRecordService;
import com.clinicCenter.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.awt.image.MemoryImageSource;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicalRecordController {

    private final PatientService patientService;
    private final MedicalRecordService medicalRecordService;

    @PostMapping(value = "/newMedicalRecord")
    public void newMedicalRecord(@RequestBody Long id){
        MedicalRecord medicalRecord = new MedicalRecord();
        Patient p = patientService.getById(id);
        p.setMedicalRecord(medicalRecord);
        medicalRecordService.save(medicalRecord);
        patientService.save(p);
    }

    @GetMapping(value = "/showMedicalRecord/{id}")
    public MedicalRecord getById(@PathVariable Long id){
        Patient patient = patientService.getById(id);
        MedicalRecord medicalRecord = patient.getMedicalRecord();
        return medicalRecord;
    }

    @GetMapping(value = "/editMedicalRecord/basicInfo/{id}")
    public MedicalRecord edit(@PathVariable Long id){
        Patient patient = patientService.getById(id);
        MedicalRecord medicalRecord = patient.getMedicalRecord();
        return medicalRecord;
    }

    @PutMapping(value = "/editMedicalRecord/basicInfo")
    public void editRecords(@RequestBody MedicalRecord medicalRecord){
        medicalRecordService.update(medicalRecord);
    }
}
