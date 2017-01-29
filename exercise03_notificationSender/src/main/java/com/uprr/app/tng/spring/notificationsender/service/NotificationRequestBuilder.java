package com.uprr.app.tng.spring.notificationsender.service;

import com.uprr.app.tng.spring.notificationsender.pojo.NotificationRequest;
import com.uprr.app.tng.spring.notificationsender.pojo.UserDetails;

public class NotificationRequestBuilder {
    private final UserDetailsBuilder userDetailsBuilder;
    private final MessageFormatter messageFormatter;

    public NotificationRequestBuilder(final UserDetailsBuilder userDetailsBuilder,
                                      final MessageFormatter messageFormatter) {
        this.userDetailsBuilder = userDetailsBuilder;
        this.messageFormatter = messageFormatter;
    }

    public NotificationRequest getRequest(final String employeeId, final String message) {
        final UserDetails userDetails      = this.userDetailsBuilder.buildUserDetails(employeeId);
        final String      formattedMessage = this.messageFormatter.formatMessage(message);
        return this.buildRequest(userDetails, formattedMessage);
    }

    private NotificationRequest buildRequest(final UserDetails userDetails,
                                             final String formattedMessage) {
        final NotificationRequest notificationRequest = new NotificationRequest();
        notificationRequest.setCustomerName(userDetails.getFirstName() + userDetails.getLastName());
        notificationRequest.setMessage(formattedMessage);
        notificationRequest.setToAddress(userDetails.getEmailAddress());
        return notificationRequest;
    }


}
