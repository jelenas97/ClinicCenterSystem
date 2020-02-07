package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationType;
import com.clinicCenter.model.Patient;
import com.clinicCenter.repository.MedicalExaminationTypeRepository;
import com.clinicCenter.repository.MedicamentRepository;
import com.clinicCenter.service.MedicalExaminationTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Service
public class MedicalExaminationTypeServiceImpl implements MedicalExaminationTypeService {

    @Autowired
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Override
    public List<MedicalExaminationType> getAll() {
        return this.medicalExaminationTypeRepository.findAll();
    }

    @Override
    public MedicalExaminationType getById(Long id) {
        return this.medicalExaminationTypeRepository.getOne(id);
    }

    @Override
    public void removeById(Long id) {
        this.medicalExaminationTypeRepository.deleteFromDoctorTypes(id);
        this.medicalExaminationTypeRepository.deleteById(id);
    }


    @Override
    public int updateType(MedicalExaminationType type) {
        return this.medicalExaminationTypeRepository.updateType(type.getId(), type.getName(), type.getPrice());
    }

    @Override
    public Collection<MedicalExaminationType> getAllMedicalExaminationTypes() {
        return medicalExaminationTypeRepository.findAll();
    }

    @Override
    public void save(MedicalExaminationType type) {
        this.medicalExaminationTypeRepository.save(type);
    }
}
