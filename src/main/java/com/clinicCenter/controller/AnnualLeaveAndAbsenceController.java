package com.clinicCenter.controller;


import com.clinicCenter.model.AnnualLeaveRequest;
import com.clinicCenter.model.Doctor;
import com.clinicCenter.model.Nurse;
import com.clinicCenter.model.User;
import com.clinicCenter.service.*;
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
    private final EmailService emailService;
    private final AnnualLeaveRequestService annualLeaveRequestService;

    @PostMapping("/vacation")
    public void saveAnnualLeave(@RequestBody AnnualLeaveRequest annualLeaveRequest){

            Long userId = annualLeaveRequest.getUserId();
            User user = userService.getById(userId);
            annualLeaveRequest.setUser(user);
            annualLeaveRequestService.save(annualLeaveRequest);
    }

    @GetMapping("/vacationRequests/{id}")
    public List<AnnualLeaveRequest> getAllVacations(@PathVariable Long id){
        List<AnnualLeaveRequest> requests = annualLeaveRequestService.getAllVacationRequestsByAdminId(id);
        return requests;
    }

    @GetMapping("/absenceRequests/{id}")
    public List<AnnualLeaveRequest> getAllAbsences(@PathVariable Long id){
        List<AnnualLeaveRequest> requests = annualLeaveRequestService.getAllAbsenceRequestsByAdminId(id);
        return requests;
    }

    @PostMapping("/sendApproveMail/{id}")
    public void sendApproveMail(@PathVariable Long id) {
        AnnualLeaveRequest annualLeaveRequest = annualLeaveRequestService.getById(id);
        Doctor user = (Doctor) userService.getById(annualLeaveRequest.getUser().getId());
        emailService.sendMailToUser(user.getEmail(),"Hello Dear, "+ user.getFirstName() + " " + user.getLastName() +
                                                        " your request for " + annualLeaveRequest.getFlag() + " from " +annualLeaveRequest.getLeaveDate()
                                                        +" until "+ annualLeaveRequest.getReturnDate()
                                                        + " is approved. Have a great time!", "Automated mail");

        annualLeaveRequestService.approve(annualLeaveRequest.getId());
    }


    @PostMapping("/sendRejectMail/{id}")
    public void sendRejectMail(@RequestBody String reason, @PathVariable Long id){
        AnnualLeaveRequest request = annualLeaveRequestService.getById(id);
        User user = request.getUser();
        emailService.sendMailToUser(user.getEmail(), "Hello Dear, "+ user.getFirstName() + " " + user.getLastName() +
                                                            " your request for " + request.getFlag() + " from " +request.getLeaveDate()
                                                            +" until "+ request.getReturnDate() + " is unfortunately rejeceted " +
                                                            " because "+reason, "Automated mail");
        annualLeaveRequestService.delete(request.getId());

    }

    @DeleteMapping("/deleteRequest/{id}")
    public void deleteRequest(@PathVariable Long id){
        annualLeaveRequestService.delete(id);
    }
}
