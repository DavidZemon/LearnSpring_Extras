package com.uprr.app.tng.spring.notificationsender.config;


import com.uprr.app.tng.spring.notificationsender.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationRequestBuilderConfig {
    @Bean
    public EmployeeDetailsService employeeDetailsService() {
        return new EmployeeDetailsService();
    }

    @Bean
    public UserProfileService userProfileService() {
        return new UserProfileService();
    }

    @Bean
    public UserDetailsBuilder userDetailsBuilder() {
        return new UserDetailsBuilder(this.userProfileService(), this.employeeDetailsService());
    }

    @Bean
    public MessageFormatter messageFormatter() {
        return new MessageFormatter();
    }

    @Bean
    public NotificationRequestBuilder notificationRequestBuilder() {
        return new NotificationRequestBuilder(this.userDetailsBuilder(), this.messageFormatter());
    }
}
