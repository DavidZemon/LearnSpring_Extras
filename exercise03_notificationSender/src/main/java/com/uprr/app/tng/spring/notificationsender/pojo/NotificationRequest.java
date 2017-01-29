package com.uprr.app.tng.spring.notificationsender.pojo;

public class NotificationRequest {
    private String toAddress;
    private String customerName;
    private String message;

    public String getToAddress() {
        return this.toAddress;
    }

    public void setToAddress(final String toAddress) {
        this.toAddress = toAddress;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }
}
