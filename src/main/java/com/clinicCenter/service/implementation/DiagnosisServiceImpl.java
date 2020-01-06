package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Diagnosis;
import com.clinicCenter.repository.DiagnosisRepository;
import com.clinicCenter.service.DiagnosisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiagnosisServiceImpl implements DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    @Override
    public void save(Diagnosis diagnosis) {
        diagnosisRepository.save(diagnosis);
    }

    @Override
    public List<Diagnosis> getAll() {
        return diagnosisRepository.findAll();
    }
}
