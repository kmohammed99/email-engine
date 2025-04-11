// src/test/java/com/example/emailengine/service/EmailServiceTest.java
package com.example.emailengine.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import static org.mockito.Mockito.*;

@SpringBootTest
class EmailServiceTest {

    @MockBean
    private JavaMailSender mailSender;

    @Autowired
    private EmailService emailService;

    @Test
    void testSendEmail_success() {
        // Arrange
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        // Act
        emailService.sendEmail("test@example.com", "Test Subject", "Test Body");

        // Assert
        verify(mailSender, timeout(2000).times(1)).send(any(SimpleMailMessage.class));
    }

    @Test
    void testSendBatch_success() {
        // Arrange
        doNothing().when(mailSender).send(any(SimpleMailMessage.class));

        // Act
        emailService.sendBatch(
                java.util.List.of("one@example.com", "two@example.com"),
                "Batch Test",
                "Hello from batch!"
        );

        // Assert
        verify(mailSender, timeout(2000).times(2)).send(any(SimpleMailMessage.class));
    }
}
