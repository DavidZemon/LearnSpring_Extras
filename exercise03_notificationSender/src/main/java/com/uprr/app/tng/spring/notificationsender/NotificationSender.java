package com.uprr.app.tng.spring.notificationsender;

import com.uprr.app.tng.spring.notificationsender.pojo.NotificationRequest;
import com.uprr.app.tng.spring.notificationsender.service.NotificationRequestBuilder;
import com.uprr.app.tng.spring.notificationsender.service.NotificationSenderService;

public class NotificationSender {
    final NotificationRequestBuilder notificationRequestBuilder;
    final NotificationSenderService notificationSenderService;

    public NotificationSender(final NotificationRequestBuilder notificationRequestBuilder,
                              final NotificationSenderService notificationSenderService) {
        this.notificationRequestBuilder = notificationRequestBuilder;
        this.notificationSenderService = notificationSenderService;
    }

    public void sendNotification(final String employeeId, final String message) {
        final NotificationRequest notificationRequest = this.notificationRequestBuilder.getRequest(employeeId, message);
        this.notificationSenderService.sendEmail(notificationRequest);
    }

}
