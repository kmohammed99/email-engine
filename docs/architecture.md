# 🏗️ Project Architecture - EmailEngine

## 📦 Package Structure
```
com.example.emailengine
├── controller         # REST endpoints
│   ├── EmailController
│   └── UserController
│
├── service            # Business logic layer
│   ├── EmailService
│   └── NotificationService
│
├── scheduled          # Scheduled jobs
│   └── ReportScheduler
│
├── config             # App config (Async executor)
│   └── AsyncConfig
│
├── dto                # Data Transfer Objects
│   └── UserDto
```

## 🔁 Flow Overview

### 1. Batch Sending Flow:
```
Client (Postman/UI)
   ↓
POST /api/email/send-all-users
   ↓
EmailController → EmailService (async + retry)
   ↓
JavaMailSender → Gmail SMTP
```

### 2. Welcome Email Flow:
```
POST /api/user/register
   ↓
UserController → NotificationService
                        ↓
                  EmailService.sendEmail()
```

### 3. Scheduled Email Flow:
```
Spring Scheduler triggers ReportScheduler (every 1 min)
   ↓
NotificationService.sendSystemAlert()
   ↓
EmailService.sendEmail()
```

## 🧠 Tech Concepts Used
- Spring Boot + JavaMailSender
- Async Thread Pool Execution
- Retryable & Recover Methods
- Scheduled Tasks
- DTOs for clean separation

---

🔗 [Return to Docs Index](../README.md)

