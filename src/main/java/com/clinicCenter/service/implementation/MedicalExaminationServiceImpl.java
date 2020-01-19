package com.clinicCenter.service.implementation;

import com.clinicCenter.controller.EmailController;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.*;
import com.clinicCenter.service.MedicalExaminationService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.print.Doc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    @Autowired
    private MedicalExaminationRoomRepository medicalExaminationRoomRepository;

    @Autowired
    private EmailController emailController;

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

    @Override
    public void saveExamination(Date date, Double price, Double duration, Double discount, Long roomId, Long clinicId, Long doctorId, Long patientId, Long typeId, Long requestId) {

        MedicalExaminationType type = medicalExaminationTypeRepository.findById(typeId).get();
        System.out.println("preuzet tip id : " + type.getId());
        Clinic clinic = clinicRepository.findById(clinicId).get();
        System.out.println("preuzet clinic id : " + clinic.getId());
        User doctor = userRepository.findById(doctorId).get();
        System.out.println("preuzet doktor id : " + doctor.getId());
        User patient = userRepository.findById(patientId).get();
        System.out.println("preuzet pacijent id : " + patient.getId());
        MedicalExaminationRoom room = medicalExaminationRoomRepository.findById(roomId).get();
        System.out.println("preuzet room ud : " + room.getId());

        MedicalExamination newExam = new MedicalExamination(date, price, duration, discount, room, (Doctor)doctor, (Patient)patient, clinic, type);
        this.medicalExaminationRepository.save(newExam);

        this.medicalExaminationRequestRepository.deleteById(requestId);

        String message = "You have scheduled an examination : " +
                "\n Date : " + newExam.getDate() +
                "\n Clinic : " + newExam.getClinic().getName() + " , " + newExam.getClinic().getAddress() + " , " + newExam.getClinic().getCity() +
                "\n Doctor : " + newExam.getDoctor().getFirstName() + " " + newExam.getDoctor().getLastName() +
                "\n Examination type : " + newExam.getType().getName() +
                "\n Examination room : " + newExam.getMedicalExaminationRoom().getName() + " " + newExam.getMedicalExaminationRoom().getNumber() +
                "\n Price : " + newExam.getPrice() +
                "\n Discount : " + newExam.getDiscount() +
                "\n Duration : " + newExam.getDuration() +
                "\n  " +
                "\n Confirm : " + "http://localhost:4200/confirmScheduledExamination/" + newExam.getId() +
                "\n Decline : " + "http://localhost:4200/declineScheduledExamination/" + newExam.getId();

        String message2 = "You have an examination scheduled : " +
                "\n Date : " + newExam.getDate() +
                "\n Clinic : " + newExam.getClinic().getName() + " , " + newExam.getClinic().getAddress() + " , " + newExam.getClinic().getCity() +
                "\n Patient : " + newExam.getPatient().getFirstName() + " " + newExam.getPatient().getLastName() +
                "\n Examination type : " + newExam.getType().getName() +
                "\n Examination room : " + newExam.getMedicalExaminationRoom().getName() + " " + newExam.getMedicalExaminationRoom().getNumber() +
                "\n Duration : " + newExam.getDuration();

        emailController.sendMail(patient.getEmail(), message, "Automated mail : Confirm or decline scheduled examination");
        emailController.sendMail(doctor.getEmail(), message2, "Automated mail : Confirm or decline scheduled examination");
    }

    @Override
    public void confirmScheduledExamination(Long id) {
        medicalExaminationRepository.confirm(id);
    }

    @Override
    public void declineScheduledExamination(Long id) {
        medicalExaminationRepository.deleteById(id);
    }
}
