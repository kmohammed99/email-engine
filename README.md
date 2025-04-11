# 📧 EmailEngine - Spring Boot Async Email Service
![Java](https://img.shields.io/badge/java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/SpringBoot-3.4.4-brightgreen?logo=spring)
![Build](https://img.shields.io/badge/build-passing-brightgreen)
![License](https://img.shields.io/badge/license-MIT-blue.svg)

A professional and extensible Spring Boot project for sending emails asynchronously using Gmail SMTP. Supports retry mechanism, batch sending, welcome notifications, scheduled reports, and unit testing.

---

## 🚀 Features

- ✅ Send plain text emails using Gmail SMTP
- ✅ Asynchronous processing using `@Async` with custom thread pool
- ✅ Retry failed emails with `@Retryable` & `@Recover`
- ✅ Batch email sending to multiple recipients
- ✅ Welcome email on user registration
- ✅ Scheduled email task using `@Scheduled`
- ✅ SLF4J logging with `@Slf4j`
- ✅ Unit tests with `@MockBean`

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot 3.4.4
- Spring Mail
- Spring Retry
- Spring AOP
- Spring Scheduler
- Lombok
- JUnit 5 & Mockito

---

## 🔧 Setup Instructions

### 1️⃣ Clone the repo
```bash
git clone https://github.com/your-username/EmailEngine.git
cd EmailEngine
```

### 2️⃣ Configure Gmail SMTP
Enable **App Passwords** in your Gmail settings:
- Activate 2FA
- Go to [App Passwords](https://myaccount.google.com/apppasswords)
- Create a password for "Mail > Other > SpringBoot"

### 3️⃣ Add `application.properties`
```properties
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your-email@gmail.com
spring.mail.password=your-app-password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

---

## ▶️ Running the App
```bash
mvn spring-boot:run
```

Access endpoints:
- POST `/api/email/send-all-users` → Batch send static list
- POST `/api/user/register` → Register & welcome email

---

## 🧪 Running Tests
```bash
mvn test
```

---

## 📁 Project Structure
```
com.example.emailengine
├── controller
│   └── EmailController, UserController
├── service
│   └── EmailService, NotificationService
├── scheduled
│   └── ReportScheduler
├── dto
│   └── UserDto.java
├── config
│   └── AsyncConfig.java
```

---
## 📚 Documentation

- [🧱 Architecture](docs/architecture.md)
- [📧 Email Scenarios](docs/emails-explained.md)
- [⚙️ Threading & Retry](docs/threading.md)

  
## 🌟 License
MIT — Free to use and modify.

---

## 💼 Author
**Khaled Mohamed**  
[GitHub](https://github.com/kmohammed99?tab=repositories)
