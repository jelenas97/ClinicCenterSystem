package com.clinicCenter.service.implementation;

import com.clinicCenter.model.*;
import com.clinicCenter.repository.OperationRepository;
import com.clinicCenter.repository.OperationRequestRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.service.EmailService;
import com.clinicCenter.service.OperationService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class OperationServiceImpl implements OperationService {

    @Autowired
    private OperationRepository operationRepository;

    @Autowired
    private OperationRoomRepository operationRoomRepository;

    @Autowired
    private OperationRequestRepository operationRequestRepository;

    @Autowired
    private EmailService emailService;

    @Override
    public void saveOperation(OperationRequest operationRequest, Date dd, Double price, Double discount, Long roomId, Long requestId, Set<Doctor> doctors) {
        OperationRoom operationRoom = operationRoomRepository.findById(roomId).get();
        System.out.println("ovo je operacijska sala" + operationRoom.getName());
        Doctor doctor = operationRequest.getDoctor();
        System.out.println("Ovo je doktor" + doctor.getFirstName());
        Clinic clinic = operationRequest.getClinic();
        System.out.println("Ovo je klinika" + clinic.getName());
        Patient patient = operationRequest.getPatient();
        System.out.println("Ovo je pacijent" + patient.getFirstName());

        Operation newOperation = new Operation(dd, price, discount,operationRequest.getDuration(), operationRoom, doctor, patient, clinic, doctors);
        operationRepository.save(newOperation);

        operationRequestRepository.deleteById(requestId);

        String message = "You have scheduled an operation : " +
                "\n Date : " + newOperation.getDate() +
                "\n Clinic : " + newOperation.getClinic().getName() + " , " + newOperation.getClinic().getAddress() + " , " + newOperation.getClinic().getCity() +
                "\n Doctor : " + newOperation.getDoctor().getFirstName() + " " + newOperation.getDoctor().getLastName() +
                "\n Price : " + newOperation.getPrice() +
                "\n Discount : " + newOperation.getDiscount() +
                "\n Duration : " + newOperation.getDuration();

        String message2 = "You have an operation scheduled : " +
                "\n Date : " + newOperation.getDate() +
                "\n Clinic : " + newOperation.getClinic().getName() + " , " + newOperation.getClinic().getAddress() + " , " + newOperation.getClinic().getCity() +
                "\n Patient : " + newOperation.getPatient().getFirstName() + " " + newOperation.getPatient().getLastName() +
                "\n Duration : " + newOperation.getDuration();

        emailService.sendMailToUser(patient.getEmail(), message, "Automated mail : Scheduled operation");
        if (doctors != null ) {
            for (Doctor doc : doctors) {
                emailService.sendMailToUser(doc.getEmail(), message2, "Automated mail : Scheduled operation");

            }
        }


    }

    @Override
    public List<Operation> getAllByDoctorId(Long id) {
        return operationRepository.getAllByDoctorId(id);
    }
}
