// service/NotificationService.java
package com.example.emailengine.service;

import com.example.emailengine.dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    private final EmailService emailService;

    public NotificationService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendWelcome(List<UserDto> users) {

        for (UserDto user : users) {
            String subject = "Welcome " + user.getName();
            String body = "Hi " + user.getName() + ", welcome to our system 🎉";
            emailService.sendEmail(user.getEmail(), subject, body);
        }
    }

    public void sendSystemAlert(String to) {
        emailService.sendEmail(
                to,
                "System Notification",
                "This is an automatic system notification."
        );
    }
}
