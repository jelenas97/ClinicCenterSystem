package com.clinicCenter.service.implementation;

import com.clinicCenter.model.*;
import com.clinicCenter.repository.*;
import com.clinicCenter.service.MedicalExaminationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

@Service
public class MedicalExaminationServiceImpl implements MedicalExaminationService {

    @Autowired
    private MedicalExaminationRepository medicalExaminationRepository;

    @Autowired
    private MedicalExaminationRequestRepository medicalExaminationRequestRepository;

    @Autowired
    private MedicalExaminationTypeRepository medicalExaminationTypeRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void sendRequest(Long typeId, Date date, Long clinicId, Long doctorId, Long patientId) {
        MedicalExaminationType type = medicalExaminationTypeRepository.findById(typeId).get();
        System.out.println("preuzet tip id : " + type.getId());
        Clinic clinic = clinicRepository.findById(clinicId).get();
        System.out.println("preuzet clinic id : " + clinic.getId());
        User doctor = userRepository.findById(doctorId).get();
        System.out.println("preuzet doktor id : " + doctor.getId());
        User patient = userRepository.findById(patientId).get();
        System.out.println("preuzet pacijent id : " + patient.getId());

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, (Doctor)doctor, (Patient)patient);
        medicalExaminationRequestRepository.save(newReq);
    }

    @Override
    public Collection<MedicalExaminationRequest> getAllExaminationRequests(Long adminId) {
        return medicalExaminationRequestRepository.getRequestForClinic(adminId);
    }

    @Override
    public MedicalExaminationRequest getById(Long requestId) {
        return medicalExaminationRequestRepository.findById(requestId).get();
    }
}
