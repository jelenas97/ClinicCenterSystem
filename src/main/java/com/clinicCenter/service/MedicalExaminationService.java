package com.clinicCenter.service;

import com.clinicCenter.model.MedicalExaminationRequest;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public interface MedicalExaminationService {
    void sendRequest(Long typeId, Date date, Long clinicId, Long doctorId, Long patientId);

    Collection<MedicalExaminationRequest> getAllExaminationRequests(Long adminId);

    MedicalExaminationRequest getById(Long requestId);

    void saveExamination(Date date, Double price, Double duration, Double discount, Long roomId, Long clinicId, Long doctorId, Long patientId, Long typeId, Long requestId);

    void confirmScheduledExamination(Long id);

    void declineScheduledExamination(Long id);

    void removeMedicalExaminationRequestById(Long i);

    List<MedicalExaminationRequest> getAllExamsRequests();
}
