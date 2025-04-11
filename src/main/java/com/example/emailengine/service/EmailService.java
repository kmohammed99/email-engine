// service/EmailService.java
package com.example.emailengine.service;

import jakarta.mail.SendFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class EmailService {

    private final JavaMailSender mailSender;

    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    @Retryable(
            value = {MailException.class, MailSendException.class, SendFailedException.class},
            maxAttempts = 3,
            backoff = @Backoff(delay = 2000)
    )
    @Async("customExecutor")
    public void sendEmail(String to, String subject, String body) {
        log.info("➡️ Trying to send email to: {}", to);
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);
        msg.setFrom("Khaled.mo.moustafa@gmail.com");
        log.info("Thread: {} retrying...", Thread.currentThread().getName());
        mailSender.send(msg);
    }

    @Async("customExecutor")
    public void sendBatch(List<String> toList, String subject, String body) {
        for (String to : toList) {
            sendEmail(to, subject, body); // No try-catch to allow recover to trigger
        }
    }

    @Recover
    public void recover(MailException e, String to, String subject, String body) {
        log.error("❌ Failed to send email to {} after retries: {}", to, e.getMessage());
        // Log to DB or take alternative action here
    }
}