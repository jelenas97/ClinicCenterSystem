package com.clinicCenter.controller;

import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.MedicalExamination;
import com.clinicCenter.model.Operation;
import com.clinicCenter.model.OperationRequest;
import com.clinicCenter.service.OperationService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class OperationController {

    @Autowired
    private OperationService operationService;

    @Autowired
    private UserService userService;

    @PostMapping("saveOperation/{roomId}/{date}/{requestId}/{selectedTerm}/{doctors}")
    public void saveOperation(@PathVariable Long roomId, @PathVariable String date,
                              @PathVariable Long requestId, @PathVariable String selectedTerm, @RequestBody OperationRequest operationRequest,
                              @PathVariable Long[] doctors) throws ParseException {
        System.out.println("Ovo su doktori koji jos dolaze na operaciju" + Arrays.toString(doctors));
        System.out.println(operationRequest.getPrice() + "   " + operationRequest.getDiscount());
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

        Set<Doctor> doctors1 = new HashSet<>();
        doctors1.add(operationRequest.getDoctor());
        System.out.println("glavni lekar" + operationRequest.getDoctor().getId());
        System.out.println("posle glavni lekar" + doctors1.size());

        if (doctors[0] != 0) {
            for (Long id : doctors) {
                doctors1.add((Doctor) userService.getById(id));
                System.out.println(" lekar" + id);
                System.out.println("posle  lekar" + doctors1.size());
            }
        }

        System.out.println("ovde je koliko ima elemenata u doktorima" + doctors1.size());
        operationService.saveOperation(operationRequest, dd, operationRequest.getPrice(), operationRequest.getDiscount(), roomId, requestId, doctors1);

    }


    @GetMapping("/medicalOperations/doctor/{id}")
    public List<Operation> getAll(@PathVariable Long id){
        return operationService.getAllByDoctorId(id);
    }

    @GetMapping("medicalOperations/{roomId}")
    public Collection<Operation> getOperationsFromRoom(@PathVariable Long roomId) {
        return operationService.getAllOperationsFromRoom(roomId);
    }
}
