package com.uprr.app.tng.spring.purchaseorder.service;


import com.uprr.app.tng.spring.purchaseorder.pojo.SomeOrderDetails;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailsService {
    public SomeOrderDetails getSomeOrderDetails(final String orderId) {
        return this.pretendServiceCall(orderId);
    }

    private SomeOrderDetails pretendServiceCall(final String orderId) {
        final SomeOrderDetails someOrderDetails = new SomeOrderDetails();
        someOrderDetails.setOrderId(orderId);
        someOrderDetails.setCustomerId("AIKEN342380");
        return someOrderDetails;
    }

}
