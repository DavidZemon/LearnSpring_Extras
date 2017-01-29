package com.uprr.app.tng.spring.purchaseorder.service;

import com.uprr.app.tng.spring.purchaseorder.pojo.OrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderService {
    @Autowired
    private OrderDetailsRequestBuilder orderDetailsRequestBuilder;
    @Autowired
    private OrderDetailsProcessor      orderDetailsProcessor;

    public void purchaseOrder(final String orderId) {
        final OrderDetails orderDetails = this.orderDetailsRequestBuilder.buildOrderDetails(orderId);
        this.orderDetailsProcessor.processOrder(orderDetails);
    }
}
