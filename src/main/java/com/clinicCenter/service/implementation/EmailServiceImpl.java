package com.clinicCenter.service.implementation;


import com.clinicCenter.controller.UserController;
import com.clinicCenter.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private Environment env;

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @Override
    @Async
    public void sendNotification(String email, String message, String subject) throws MailException, InterruptedException{
        System.out.println("Sending email...");

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setFrom(env.getProperty("spring.mail.username"));
        mail.setSubject(subject);
        mail.setText(message);
        javaMailSender.send(mail);

        System.out.println("Email sent!");
    }

    @Override
    public String sendMailToUser(String email, String message, String subject) {
        try {
            sendNotification(email, message, subject);
        } catch (Exception e) {
            logger.info("Error sending the mail: " + e.getMessage());
        }
        return "success";
    }
}
