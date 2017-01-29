package com.uprr.app.tng.spring.purchaseorder.config;

import com.uprr.app.tng.spring.notificationsender.NotificationSender;
import com.uprr.app.tng.spring.notificationsender.config.NotificationSenderConfig;
import com.uprr.app.tng.spring.notificationsender.service.NotificationRequestBuilder;
import com.uprr.app.tng.spring.notificationsender.service.NotificationSenderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.uprr.app.tng.spring.purchaseorder")
@Import(NotificationSenderConfig.class)
public class PurchaseOrderConfig {
    @Bean
    public NotificationSender notificationSender(final NotificationRequestBuilder notificationRequestBuilder,
                                                 final NotificationSenderService notificationSenderService) {
        return new NotificationSender(notificationRequestBuilder, notificationSenderService);
    }
}
