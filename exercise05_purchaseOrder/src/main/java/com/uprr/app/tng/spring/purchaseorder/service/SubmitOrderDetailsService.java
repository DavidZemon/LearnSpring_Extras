package com.uprr.app.tng.spring.purchaseorder.service;

import com.uprr.app.tng.spring.purchaseorder.pojo.OrderDetails;

public class SubmitOrderDetailsService {
    public boolean submitOrderDetails(final OrderDetails orderDetails) {
        return this.pretendServiceCall(orderDetails);
    }

    private boolean pretendServiceCall(final OrderDetails orderDetails) {
        return orderDetails != null;
    }

}
