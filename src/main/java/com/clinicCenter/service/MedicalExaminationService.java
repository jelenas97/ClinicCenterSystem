package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.MedicalExaminationRequest;

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
}
