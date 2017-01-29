package com.uprr.app.tng.spring.purchaseorder.service;

import com.uprr.app.tng.spring.notificationsender.NotificationSender;
import com.uprr.app.tng.spring.purchaseorder.pojo.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("FieldMayBeFinal")
public class OrderDetailsProcessor {
    @Autowired
    private SubmitOrderDetailsService submitOrderDetailsService;
    @Autowired
    private NotificationSender        notificationSender;

    public OrderDetailsProcessor(
        final SubmitOrderDetailsService submitOrderDetailsService,
        final NotificationSender notificationSender) {
        this.submitOrderDetailsService = submitOrderDetailsService;
        this.notificationSender = notificationSender;
    }

    public void processOrder(final OrderDetails orderDetails) {
        this.submitOrderDetailsService.submitOrderDetails(orderDetails);
        this.notificationSender.sendNotification(orderDetails.getCustomerDetails().getUserProfile().getCustomerId(),
                                                 "Your order has been processed.");

    }

}
