// EmailController.java
package com.example.emailengine.controller;

import com.example.emailengine.service.EmailService;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    // ✅ Static List of emails (hardcoded)
    private final List<String> staticEmails = Arrays.asList(
            "khaledmohammed4000@icloud.com",
            "Khaled.mo.moustafa@gmail.com"
    );

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send-all-users")
    public String sendToStaticEmails() {
        emailService.sendBatch(
                staticEmails,
                "📢 Important Update",
                "Hello! This is a static email broadcast."
        );

        return "✅ Emails are being sent to static users!";
    }
}
