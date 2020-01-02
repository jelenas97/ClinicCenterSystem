package com.clinicCenter.service;

import java.util.Date;

public interface MedicalExaminationService {
    void sendRequest(Long typeId, Date date, Long clinicId, Long doctorId);
}
