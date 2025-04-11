// scheduled/ReportScheduler.java
package com.example.emailengine.scheduled;

import com.example.emailengine.service.NotificationService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReportScheduler {

    private final NotificationService notificationService;

    public ReportScheduler(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @Scheduled(cron = "0 */1 * * * *") // every 1 minute
    public void sendDailyReport() {
        notificationService.sendSystemAlert("khaledmohammed4000@icloud.com");
    }
}
