package com.clinicCenter.controller;

import com.clinicCenter.model.Medicament;
import com.clinicCenter.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicamentController {

    @Autowired
    private MedicamentService medicamentService;

    @PostMapping("/medicament")
    public void addMedicament(@RequestBody Medicament medicament){
        System.out.println(medicament.getName());
        medicamentService.save(medicament);
    }



}
