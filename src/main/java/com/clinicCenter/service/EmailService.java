package com.clinicCenter.service;

import com.clinicCenter.model.User;
import org.springframework.mail.MailException;

public interface EmailService {
    void sendNotification(String email) throws MailException, InterruptedException;
}
