package com.clinicCenter.service;

import com.clinicCenter.model.Nurse;

import java.util.List;

public interface NurseService {

    void save(Nurse nurse);
    List<Nurse> getAll();
    Nurse getById(Long id);

}
