package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.MedicalExaminationRequest;
import com.clinicCenter.model.User;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface MedicalExaminationService {
    void sendRequest(Long typeId, Date date, Long clinicId, Long doctorId, Long patientId);

    Collection<MedicalExaminationRequest> getAllExaminationRequests(Long adminId);

    MedicalExaminationRequest getById(Long requestId);

    void saveExamination(Date date, Double price, Double duration, Double discount, Long roomId, Long clinicId, Long doctorId, Long patientId, Long typeId, Long requestId, Boolean predefined);

    void confirmScheduledExamination(Long id);

    void declineScheduledExamination(Long id);

    Collection<MedicalExamination> getAllExaminationsFromRoom(Long roomId);

    void removeMedicalExaminationRequestById(Long i);

    List<MedicalExaminationRequest> getAllExamsRequests();

    Collection<MedicalExamination> getAllPredefinedMedicalExaminations();

    void schedulePredefinedMedicalExamination(Long examinationId, Long patientId);

    Collection<MedicalExamination> getAllExaminationsPatientCanRate(Long patientId);

    void rateDoctor(Long examId);

    void rateClinic(Long examId);

    Collection<MedicalExamination> getAllExaminationsFromDoctor(Long id);

    List<Integer> getAllExaminationsDaily(Long id);

    Collection<MedicalExamination> getDoctorsExaminationsByIdAndDate(Long doctorId, Date date1, Date date2);

    List<Integer> getAllExaminationsMonthly(Long id);

    List<Integer> getAllExaminationsYearly(Long id);

    List<Long> getIncomes(Long id);

    MedicalExamination getExamById(Long examId);

    Collection<User> getAvailableDoctorsForOperation(Date date1, Date date2, Long clinicId, Long doctorId);

    Collection<String> getAvailableTermsForDoctor(Long doctorId, String date) throws ParseException;

    Boolean canStartExam(Long patientId, Long doctorId);

    Boolean pastExam(Long patientId, Long doctorId);

    Boolean nurseAndPatient(Long patientId, Long nurseId);

    MedicalExamination examDoctorPatient(Long patientId, Long doctorId);
}
