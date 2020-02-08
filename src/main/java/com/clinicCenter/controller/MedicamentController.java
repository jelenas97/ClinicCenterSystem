package com.clinicCenter.controller;

import com.clinicCenter.model.Medicament;
import com.clinicCenter.service.MedicamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentController {

    private final MedicamentService medicamentService;

    @PostMapping("/medicament")
    @PreAuthorize("hasRole('CLINIC_CENTER_ADMIN') or hasRole('CLINIC_CENTER_ADMIN_SUPER') or hasRole('DOCTOR')")
    public void addMedicament(@RequestBody Medicament medicament){
        medicamentService.save(medicament);
    }

    @GetMapping("/allMedicaments")
    public List<Medicament> getAll(){
       return medicamentService.getAll();
    }
}
