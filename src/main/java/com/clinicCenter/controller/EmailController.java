package com.clinicCenter.controller;

import com.clinicCenter.model.User;
import com.clinicCenter.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class EmailController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private EmailService emailService;

    public String sendMail(User user) {
        try {
            emailService.sendNotification(user.getEmail());
        } catch (Exception e) {
            logger.info("Error sending the mail: " + e.getMessage());
        }
        return "success";
    }
}
