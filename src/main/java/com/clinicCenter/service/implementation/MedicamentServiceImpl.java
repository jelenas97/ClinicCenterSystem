package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Medicament;
import com.clinicCenter.repository.MedicamentRepository;
import com.clinicCenter.service.MedicamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;

    @Override
    public void save(Medicament medicament) {
        medicamentRepository.save(medicament);
    }

    @Override
    public List<Medicament> getAll() {
        return medicamentRepository.findAll();
    }

    @Override
    public Medicament getById(Long id) {
        return medicamentRepository.getOne(id);
    }
}
