package com.clinicCenter.service.implementation;

import com.clinicCenter.model.*;
import com.clinicCenter.repository.OperationRepository;
import com.clinicCenter.repository.OperationRequestRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.service.OperationService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationRoomRepository operationRoomRepository;

    @Autowired
    private OperationRequestRepository operationRequestRepository;

    @Override
    public void saveOperation(OperationRequest operationRequest, Date dd, Double price, Double discount, Long roomId, Long requestId) {
        OperationRoom operationRoom = operationRoomRepository.findById(roomId).get();
        System.out.println("ovo je operacijska sala" + operationRoom.getName());
        Doctor doctor = operationRequest.getDoctor();
        System.out.println("Ovo je doktor" + doctor.getFirstName());
        Clinic clinic = operationRequest.getClinic();
        System.out.println("Ovo je klinika" + clinic.getName());
        Patient patient = operationRequest.getPatient();
        System.out.println("Ovo je pacijent" + patient.getFirstName());

        Operation newOperation = new Operation(dd, price, discount,operationRequest.getDuration(), operationRoom, doctor, patient, clinic);
        operationRepository.save(newOperation);

        operationRequestRepository.deleteById(requestId);
    }
}
