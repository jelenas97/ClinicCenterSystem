package com.clinicCenter.controller;

import com.clinicCenter.model.MedicalExaminationRoom;
import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.service.MedicalExaminationRoomService;
import com.clinicCenter.service.MedicalExaminationService;
import com.clinicCenter.service.OperationRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Collection;


@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OperationRequestController {

    @Autowired
    private OperationRequestService operationRequestService;

    @PostMapping("/operationRequest/{selectedTerm}")
    public void addOperationRequest(@RequestBody OperationRequest request, @PathVariable String selectedTerm){
        String[] time = selectedTerm.split(":");
        String hours = time[0];
        String minutes = time[1];


        Calendar cal = Calendar.getInstance();
        cal.setTime(request.getDate());

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date d = cal.getTime();
        request.setDate(d);

        operationRequestService.save(request);
    }


    @GetMapping("auth/getAllOperationRequests")
    public Collection<OperationRequest> getAllOperationRequests() {
        return operationRequestService.getAllOperationRequests();
    }
}
