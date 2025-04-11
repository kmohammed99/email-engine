# 📧 Email Scenarios - EmailEngine

## 1️⃣ Static Batch Emails
**Use Case:** Send the same message to a predefined list.

### Endpoint
```http
POST /api/email/send-all-users
```

### Implementation
- Controller injects a static list
- Calls `EmailService.sendBatch()`
- Each email is sent with retry and async thread

### Example
```java
List<String> staticEmails = List.of(
        "user1@example.com", "user2@example.com"
);
```

---

## 2️⃣ Welcome Email
**Use Case:** Send welcome email after user registration

### Endpoint
```http
POST /api/user/register
```

### Flow
- UserController simulates a new user
- Calls `NotificationService.sendWelcome()`
- Welcome message sent via `EmailService.sendEmail()`

---

## 3️⃣ Scheduled Notification
**Use Case:** Send alert/report email on schedule

### Location
```java
@Scheduled(cron = "0 */1 * * * *") // every 1 minute
```

### Triggered from
```java
ReportScheduler.sendDailyReport()
```

---

## ✅ Notes
- All email sending is handled via `JavaMailSender`
- Uses `@Retryable` for up to 3 attempts
- Final fallback handled in `@Recover`

---

🔗 [Return to Docs Index](../README.md)

