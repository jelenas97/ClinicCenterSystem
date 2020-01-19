package com.clinicCenter.controller;


import com.clinicCenter.model.AnnualLeaveRequest;
import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.Nurse;
import com.clinicCenter.model.User;
import com.clinicCenter.service.AnnualLeaveRequestService;
import com.clinicCenter.service.DoctorService;
import com.clinicCenter.service.NurseService;
import com.clinicCenter.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.security.auth.login.AccountNotFoundException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class AnnualLeaveAndAbsenceController {

    private final UserService userService;
    private final NurseService nurseService;
    private final DoctorService doctorService;
    private final EmailController emailController;
    private final AnnualLeaveRequestService annualLeaveRequestService;

    @PostMapping("/absence")
    public void saveAbsence(@RequestBody AnnualLeaveRequest annualLeaveRequest) throws ParseException {

            Long userId = annualLeaveRequest.getUserId();
            User user = userService.getById(userId);

            if(user.getType().equals("DO")){
                Doctor d = doctorService.getById(userId);
                annualLeaveRequest.setRefDoctor(d);
            }else{
                Nurse n = nurseService.getById(userId);
                annualLeaveRequest.setRefNurse(n);
            }

            annualLeaveRequest.setUserId(userId);
            annualLeaveRequest.setFlag("absence");
            annualLeaveRequestService.save(annualLeaveRequest);
    }

    @PostMapping("/vacation")
    public void saveAnnualLeave(@RequestBody AnnualLeaveRequest annualLeaveRequest){

            Long userId = annualLeaveRequest.getUserId();
            User user = userService.getById(userId);

            if(user.getType().equals("DO")){
                Doctor d = doctorService.getById(userId);
                annualLeaveRequest.setRefDoctor(d);
            }else{
                Nurse n = nurseService.getById(userId);
                annualLeaveRequest.setRefNurse(n);
            }

            annualLeaveRequest.setUserId(userId);
            annualLeaveRequest.setFlag("vacation");
            annualLeaveRequestService.save(annualLeaveRequest);
    }

    @GetMapping("/vacationRequests")
    public List<AnnualLeaveRequest> getAllVacations(){
        List<AnnualLeaveRequest> requests = annualLeaveRequestService.getAllVacationRequests();
        return requests;
    }

    @GetMapping("/absenceRequests")
    public List<AnnualLeaveRequest> getAllAbsences(){
        List<AnnualLeaveRequest> requests = annualLeaveRequestService.getAllAbsenceRequests();
        return requests;
    }

    @PostMapping("/sendApproveMail")
    public void sendApproveMail(@RequestBody AnnualLeaveRequest request){
        User user = userService.getById(request.getUserId());
        emailController.sendMail(user.getEmail(),"Hello Dear, "+ user.getFirstName() + " " + user.getLastName() +
                                                        " your request for " + request.getFlag() + " from " +request.getLeaveDate()
                                                        +" until "+ request.getReturnDate()
                                                        + " is approved. Have a great time!", "Automated mail");
    }


    @PostMapping("/sendRejectMail")
    public void sendRejectMail(@RequestBody AnnualLeaveRequest request){
        User user = userService.getById(request.getUserId());
        emailController.sendMail(user.getEmail(),"e boli me uvo ne moze", "Automated mail");
    }

    @DeleteMapping("/deleteRequest/{id}")
    public void deleteRequest(@PathVariable Long id){
        annualLeaveRequestService.delete(id);
    }
}
