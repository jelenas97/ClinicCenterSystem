package com.clinicCenter.service;

import com.clinicCenter.model.Medicament;

import java.util.List;

public interface MedicamentService {
    void save(Medicament medicament);
    List<Medicament> getAll();
}
