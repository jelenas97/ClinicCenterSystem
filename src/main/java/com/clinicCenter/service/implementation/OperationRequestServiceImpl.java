package com.clinicCenter.service.implementation;

import com.clinicCenter.model.MedicalExaminationRequest;
import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.model.OperationRoom;
import com.clinicCenter.repository.OperationRequestRepository;
import com.clinicCenter.repository.OperationRoomRepository;
import com.clinicCenter.service.OperationRequestService;
import com.clinicCenter.service.OperationService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OperationRequestServiceImpl implements OperationRequestService {
    @Autowired
    private OperationRequestRepository operationRequestRepository;

    @Autowired
    private OperationRoomRepository operationRoomRepository;

    @Autowired
    private OperationService operationService;

    @Override
    public Collection<OperationRequest> getAllOperationRequests() {
        return operationRequestRepository.findAll();
    }

    @Override
    public OperationRequest getOperationRequestById(Long requestId) {
        return operationRequestRepository.findById(requestId).get();
    }

    @Override
    public void automaticSchedule() {
        int numberOfAllRequests = this.getAllOperationRequests().size();

        for (int i = 0; i < numberOfAllRequests; i++) {
            List<OperationRequest> allRequests = operationRequestRepository.findAll();
            OperationRequest oneRequest = allRequests.get(0);
            List<OperationRoom> availableRooms = operationRoomRepository.getAvailableRooms(oneRequest.getClinic().getId(), oneRequest.getDate());
            System.out.println(availableRooms);
            try {
                operationService.saveOperation(oneRequest, oneRequest.getDate(), 10000.0, 0.0, availableRooms.get(0).getId(), oneRequest.getId(), null);

            } catch (IndexOutOfBoundsException ioobe) {
                List<OperationRoom> availableRooms2;
                int addDays = 1;
                Date newDate;
                do {
                    Calendar c = Calendar.getInstance();
                    c.setTime(oneRequest.getDate());
                    c.add(Calendar.DATE, addDays);
                    newDate = c.getTime();
                    availableRooms2 = operationRoomRepository.getAvailableRooms(oneRequest.getClinic().getId(), newDate);
                    addDays++;
                } while (availableRooms2.size() == 0);
                operationService.saveOperation(oneRequest, newDate, 10000.0, 0.0, availableRooms2.get(0).getId(), oneRequest.getId(), null);

            }
        }
    }

    @Override
    public void save(OperationRequest request) {
        operationRequestRepository.save(request);
    }
}
