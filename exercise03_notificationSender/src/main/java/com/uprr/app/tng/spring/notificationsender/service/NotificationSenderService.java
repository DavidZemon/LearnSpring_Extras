package com.uprr.app.tng.spring.notificationsender.service;

import com.uprr.app.tng.spring.notificationsender.pojo.NotificationRequest;

public class NotificationSenderService {
    final int serviceTimeout;

    public NotificationSenderService(final int serviceTimeout) {
        this.serviceTimeout = serviceTimeout;
    }

    public void sendEmail(final NotificationRequest notificationRequest) {
        this.pretendServiceCall(notificationRequest);
    }

    private void pretendServiceCall(final NotificationRequest notificationRequest) {
        // Here we are pretending to send the notification
    }


}
