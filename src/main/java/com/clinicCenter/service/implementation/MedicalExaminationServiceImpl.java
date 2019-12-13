package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.repository.MedicalExaminationTypeRepository;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MedicalExaminationServiceImpl implements MedicalExaminationTypeService {

    @Autowired
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Override
    public Collection<MedicalExaminationType> getAllMedicalExaminationTypes() {
        return medicalExaminationTypeRepository.findAll();
    }
}
