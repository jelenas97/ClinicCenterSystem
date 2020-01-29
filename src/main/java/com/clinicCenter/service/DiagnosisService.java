package com.clinicCenter.service;

import com.clinicCenter.model.Diagnosis;

import java.util.List;

public interface DiagnosisService {

    void save(Diagnosis diagnosis);
    List<Diagnosis> getAll();
    Diagnosis getById(Long id);
}
