package com.clinicCenter.service.implementation;

import com.clinicCenter.model.*;
import com.clinicCenter.repository.*;
import com.clinicCenter.service.MedicalExaminationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.util.Date;

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
    public void sendRequest(Long typeId, Date date, Long clinicId, Long doctorId) {
        MedicalExaminationType type = medicalExaminationTypeRepository.findById(typeId).get();
        System.out.println("preuzet tip id : " + type.getId());
        Clinic clinic = clinicRepository.findById(clinicId).get();
        System.out.println("preuzet clinic id : " + clinic.getId());
        Doctor doctor = (Doctor) userRepository.findById(doctorId).get();
        System.out.println("preuzet doktor id : " + doctor.getId());
        //Patient patient = (Patient) userRepository.findById(patientId).get();

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, doctor);
        //newReq.setPatient(patient);
        medicalExaminationRequestRepository.save(newReq);
    }
}
