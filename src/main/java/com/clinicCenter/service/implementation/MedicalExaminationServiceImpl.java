package com.clinicCenter.service.implementation;

import com.clinicCenter.controller.EmailController;
import com.clinicCenter.model.*;
import com.clinicCenter.repository.*;
import com.clinicCenter.service.MedicalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

        MedicalExaminationRequest newReq = new MedicalExaminationRequest(type, date, clinic, (Doctor) doctor, (Patient) patient);
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
    public void saveExamination(Date date, Double price, Double duration, Double discount, Long roomId, Long clinicId, Long doctorId, Long patientId, Long typeId, Long requestId, Boolean predefined) {

        MedicalExaminationType type = medicalExaminationTypeRepository.findById(typeId).get();
        System.out.println("preuzet tip id : " + type.getId());
        Clinic clinic = clinicRepository.findById(clinicId).get();
        System.out.println("preuzet clinic id : " + clinic.getId());
        User doctor = userRepository.findById(doctorId).get();
        System.out.println("preuzet doktor id : " + doctor.getId());

        User patient = null;
        if (patientId != null) {
            patient = userRepository.findById(patientId).get();
            System.out.println("preuzet pacijent id : " + patient.getId());
        }

        MedicalExaminationRoom room = medicalExaminationRoomRepository.findById(roomId).get();
        System.out.println("preuzet room ud : " + room.getId());

        MedicalExamination newExam = new MedicalExamination(date, price, duration, discount, room, (Doctor) doctor, (Patient) patient, clinic, type, predefined);
        this.medicalExaminationRepository.save(newExam);

        if (requestId != null) {
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

    }

    @Override
    public void confirmScheduledExamination(Long id) {
        medicalExaminationRepository.confirm(id);
    }

    @Override
    public void declineScheduledExamination(Long id) {
        medicalExaminationRepository.deleteById(id);
    }

    @Override
    public void removeMedicalExaminationRequestById(Long i) {
        medicalExaminationRequestRepository.deleteById(i);
    }

    @Override
    public List<MedicalExaminationRequest> getAllExamsRequests() {
        return medicalExaminationRequestRepository.findAll();
    }

    @Override
    public Collection<MedicalExamination> getAllPredefinedMedicalExaminations() {
        return medicalExaminationRepository.getAllPredefinedMedicalExaminations();
    }

    @Override
    public void schedulePredefinedMedicalExamination(Long examinationId, Long patientId) {
        medicalExaminationRepository.schedulePredefinedMedicalExamination(examinationId, patientId);
        MedicalExamination examination = medicalExaminationRepository.findById(examinationId).get();

        String message = "You have scheduled an examination : " +
                "\n Date : " + examination.getDate() +
                "\n Clinic : " + examination.getClinic().getName() + " , " + examination.getClinic().getAddress() + " , " + examination.getClinic().getCity() +
                "\n Doctor : " + examination.getDoctor().getFirstName() + " " + examination.getDoctor().getLastName() +
                "\n Examination type : " + examination.getType().getName() +
                "\n Examination room : " + examination.getMedicalExaminationRoom().getName() + " " + examination.getMedicalExaminationRoom().getNumber() +
                "\n Price : " + examination.getPrice() +
                "\n Discount : " + examination.getDiscount() +
                "\n Duration : " + examination.getDuration() +
                "\n  ";

        emailController.sendMail(examination.getPatient().getEmail(), message, "Automated mail : You have scheduled examination");

    }

    @Override
    public Collection<MedicalExamination> getAllExaminationsPatientCanRate(Long patientId) {
        return medicalExaminationRepository.getAllExaminationsPatientCanRate(patientId);
    }

    @Override
    public void rateDoctor(Long examId) {
        medicalExaminationRepository.rateDoctor(examId);
    }

    @Override
    public void rateClinic(Long examId) {
        medicalExaminationRepository.rateClinic(examId);
    }

    @Override
    public Collection<MedicalExamination> getAllExaminationsFromDoctor(Long id) {
        return medicalExaminationRepository.getAllFromDoctor(id);
    }

    @Override
    public Collection<MedicalExamination> getDoctorsExaminationsByIdAndDate(Long doctorId, Date date1, Date date2) {
        return medicalExaminationRepository.getDoctorsExaminationsByIdAndDate(doctorId, date1, date2);
    }

    @Override
    public MedicalExamination getExamById(Long examId) {
        return medicalExaminationRepository.getOne(examId);
    }

    @Override
    public Collection<MedicalExamination> getAllExaminationsFromRoom(Long roomId) {
        return medicalExaminationRepository.getAllFromRoom(roomId);
    }
}
