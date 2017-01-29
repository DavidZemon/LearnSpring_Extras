package com.uprr.app.tng.spring.notificationsender.config;

import com.uprr.app.tng.spring.notificationsender.NotificationSender;
import com.uprr.app.tng.spring.notificationsender.service.NotificationRequestBuilder;
import com.uprr.app.tng.spring.notificationsender.service.NotificationSenderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(NotificationRequestBuilderConfig.class)
@PropertySource("classpath:notification.properties")
public class NotificationSenderConfig {
    @Value("${service-timeout}")
    private int serviceTimeout;

    @Bean
    public NotificationSenderService notificationSenderService() {
        return new NotificationSenderService(this.serviceTimeout);
    }

    @Bean
    public NotificationSender notificationSender(final NotificationRequestBuilder notificationRequestBuilder) {
        return new NotificationSender(notificationRequestBuilder , this.notificationSenderService());
    }
}

