package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Medicament;
import com.clinicCenter.repository.MedicamentRepository;
import com.clinicCenter.service.MedicamentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicamentServiceImpl implements MedicamentService {

    @Autowired
    private MedicamentRepository medicamentRepository;

    @Override
    public void save(Medicament medicament) {
        medicamentRepository.save(medicament);
    }

    @Override
    public Medicament getById(Long id) {
        return medicamentRepository.findById(id).get();
    }


}
