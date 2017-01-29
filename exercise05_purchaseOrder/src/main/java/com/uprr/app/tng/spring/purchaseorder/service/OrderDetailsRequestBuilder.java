package com.uprr.app.tng.spring.purchaseorder.service;

import com.uprr.app.tng.spring.purchaseorder.pojo.CustomerDetails;
import com.uprr.app.tng.spring.purchaseorder.pojo.OrderDetails;
import com.uprr.app.tng.spring.purchaseorder.pojo.SomeOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDetailsRequestBuilder {
    @Autowired
    private OrderDetailsService    orderDetailsService;
    @Autowired
    private CustomerDetailsService customerDetailsService;


    public OrderDetails buildOrderDetails(final String orderId) {
        final OrderDetails     orderDetails     = new OrderDetails();
        final SomeOrderDetails someOrderDetails = this.getOrderDetails(orderId);
        orderDetails.setSomeOrderDetails(someOrderDetails);
        orderDetails.setCustomerDetails(this.getCustomerDetails(someOrderDetails));
        return orderDetails;
    }

    private SomeOrderDetails getOrderDetails(final String orderId) {
        return this.orderDetailsService.getSomeOrderDetails(orderId);
    }

    private CustomerDetails getCustomerDetails(final SomeOrderDetails someOrderDetails) {
        return this.customerDetailsService.getCustomerDetails(
            someOrderDetails.getCustomerId());
    }
}
