package com.uprr.app.tng.spring.notificationsender;

import com.uprr.app.tng.spring.notificationsender.config.NotificationSenderConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NotificationSenderConfig.class)
public class NotificationSenderIT {
    @Autowired
    private NotificationSender notificationSender;

    @Test
    public void test() throws Exception {
        this.notificationSender.sendNotification("EMPL 333", "Email Message");
        System.out.println("You have passed");
    }
}
