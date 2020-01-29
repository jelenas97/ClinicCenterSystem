package com.clinicCenter.controller;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.OperationRoom;
import com.clinicCenter.model.Patient;
import com.clinicCenter.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping("/allPatients")
    public List<Patient> getAll(){
        List<Patient> patients = patientService.getAll();
        return patients;
    }

    @GetMapping("/allPatients/search1")
    @ResponseBody
    public ArrayList<Patient> getSearchedFromPatients1(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName) {

        ArrayList<Patient> patients = null;
        patients = patientService.getSearchedPatients(firstName,lastName);

        return patients;
    }

    @GetMapping("/allPatients/search2")
    @ResponseBody
    public ArrayList<Patient> getSearchedFromPatients2(@RequestParam(name = "firstName") String firstName, @RequestParam(name = "lastName") String lastName, @RequestParam(name = "ssn") Long ssn) {

        ArrayList<Patient> patients = null;
        patients = patientService.getSearchedPatients1(firstName, lastName, ssn);

        return patients;
    }

    @GetMapping("/getPatient/{id}")
    public Patient getById(@PathVariable Long id){
        return patientService.getById(id);
    }

}
