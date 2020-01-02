package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Nurse;
import com.clinicCenter.repository.NurseRepository;
import com.clinicCenter.service.NurseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NurseServiceImpl implements NurseService {

    private final NurseRepository nurseRepository;

    @Override
    public void save(Nurse nurse) {
        nurseRepository.save(nurse);
    }

    @Override
    public List<Nurse> getAll() {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse getById(Long id) {
        return nurseRepository.getOne(id);
    }
}
