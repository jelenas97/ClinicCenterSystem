package com.clinicCenter.controller;

import com.clinicCenter.model.Diagnosis;
import com.clinicCenter.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    @GetMapping("/allDiagnosis")
    @PreAuthorize("hasRole('CLINIC_CENTER_ADMIN') or hasRole('CLINIC_CENTER_ADMIN_SUPER')")
    public List<Diagnosis> getAll(){
        return diagnosisService.getAll();
    }

    @PostMapping("/diagnosis")
    @PreAuthorize("hasRole('CLINIC_CENTER_ADMIN') or hasRole('CLINIC_CENTER_ADMIN_SUPER')")
    public void save(@RequestBody Diagnosis diagnosis){
        diagnosisService.save(diagnosis);
    }
}
