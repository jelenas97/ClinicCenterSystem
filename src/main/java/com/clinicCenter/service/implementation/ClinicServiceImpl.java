package com.clinicCenter.service.implementation;

import com.clinicCenter.model.Clinic;
import com.clinicCenter.model.ClinicMapper;
import com.clinicCenter.repository.ClinicRepository;
import com.clinicCenter.service.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class ClinicServiceImpl implements ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;

    @Override
    public void save(Clinic clinic) {
        clinicRepository.save(clinic);
    }

    @Override
    public Collection<Clinic> getAllClinics() {
        return  clinicRepository.findAll();
    }

    @Override
    public Clinic getById(Long id) {
        return clinicRepository.getOne(id);
    }

    @Override
    public void rateClinic(Long id, Integer number) {
        System.out.println(number);
        Clinic clinic = clinicRepository.findById(id).get();
        int timesRated = clinic.getTimesRated();
        Double averageRating = clinic.getClinicAverageRating();
        double averageRating2 = (averageRating * timesRated + number) / (timesRated + 1);
        System.out.println(averageRating2);
        clinic.setClinicAverageRating(averageRating2);
        clinic.setTimesRated(timesRated + 1);
        clinicRepository.updateRating(id, averageRating2, timesRated + 1);
    }

    @Override
    public Clinic findByName(String clinicName) {
        return clinicRepository.findByName(clinicName);
    }

    @Override
    public Clinic getAdminsClinic(Long id) {
        return clinicRepository.getAdminsClinic(id);
    }

    @Override
    public void updateClinic(Clinic clinic) {
        clinicRepository.updateClinic(clinic.getId(), clinic.getName(), clinic.getDescription(), clinic.getCity(), clinic.getAddress(), clinic.getClinicAverageRating());
    }

    @Override
    public Collection<Clinic> getSearchedClinics(Long typeName) {
        return clinicRepository.getSearchedClinics(typeName);
    }

    @Override
    public Collection<Clinic> getSearchedClinicsTwo(Long typeName, Double clinicRating) {
        return clinicRepository.getSearchedClinicsTwo(typeName, clinicRating);
    }

    @Override
    public Collection<Clinic> getSearchedClinicsThree(Long typeName, String clinicName) {
        return clinicRepository.getSearchedClinicsThree(typeName, clinicName);
    }

    @Override
    public Collection<Clinic> getSearchedClinicsFour(Long typeName, String clinicName, Double clinicRating) {
        return clinicRepository.getSearchedClinicsFour(typeName, clinicName, clinicRating);
    }


}
