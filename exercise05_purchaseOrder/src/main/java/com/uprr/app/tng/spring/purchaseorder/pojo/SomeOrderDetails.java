package com.uprr.app.tng.spring.purchaseorder.pojo;

public class SomeOrderDetails {
    private String orderId;
    private String customerId;

    public String getOrderId() {
        return this.orderId;
    }

    public void setOrderId(final String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }
}
