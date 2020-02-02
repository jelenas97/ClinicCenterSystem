package com.clinicCenter.controller;

import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.service.OperationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @PostMapping("saveOperation/{roomId}/{date}/{price}/{discount}/{requestId}/{selectedTerm}")
    public void saveOperation(@PathVariable Long roomId, @PathVariable String date, @PathVariable Double price, @PathVariable Double discount,
                              @PathVariable Long requestId, @PathVariable String selectedTerm, @RequestBody OperationRequest operationRequest) throws ParseException {
        date = date.replace('_', '-');
        System.out.println(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = simpleDateFormat.parse(date);

        Calendar cal = Calendar.getInstance();
        cal.setTime(d);

        String[] time = selectedTerm.split(":");
        String hours = time[0];
        String minutes = time[1];

        cal.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hours));
        cal.set(Calendar.MINUTE, Integer.parseInt(minutes));
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);

        Date dd = cal.getTime();

        operationService.saveOperation(operationRequest, dd, price, discount, roomId, requestId);
    }
}
