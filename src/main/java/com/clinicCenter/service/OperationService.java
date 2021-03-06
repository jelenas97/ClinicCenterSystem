package com.clinicCenter.service;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.Operation;
import com.clinicCenter.model.OperationRequest;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface OperationService {
    void saveOperation(OperationRequest operationRequest, Date dd, Double price, Double discount, Long roomId, Long requestId, Set<Doctor> doctors);
    List<Operation> getAllByDoctorId(Long id);

    Collection<Operation> getAllOperationsFromRoom(Long roomId);

    Collection<Operation> getAllOperationsPatientCanRate(Long patientId);

    void rateDoctor(Long examId);

    void rateClinic(Long examId);
}
