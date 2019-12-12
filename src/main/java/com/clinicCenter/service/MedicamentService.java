package com.clinicCenter.service;

import com.clinicCenter.model.Medicament;

public interface MedicamentService {
    void save(Medicament medicament);
    Medicament getById(Long id);
}
