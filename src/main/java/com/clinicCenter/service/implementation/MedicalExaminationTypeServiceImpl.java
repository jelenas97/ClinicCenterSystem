package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.repository.MedicalExaminationTypeRepository;
import com.clinicCenter.repository.MedicamentRepository;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MedicalExaminationTypeServiceImpl implements MedicalExaminationTypeService {

    @Autowired
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Override
    public Set<MedicalExaminationType> getAll() {
        return this.medicalExaminationTypeRepository.getAll();
    }

    @Override
    public MedicalExaminationType getById(Long id) {
        return this.medicalExaminationTypeRepository.getOne(id);
    }

    @Override
    public void removeById(Long id) {
        this.medicalExaminationTypeRepository.deleteById(id);
    }

    @Override
    public int updateType(MedicalExaminationType type) {
        return this.medicalExaminationTypeRepository.updateType(type.getId(), type.getName(), type.getPrice());
    }
}
