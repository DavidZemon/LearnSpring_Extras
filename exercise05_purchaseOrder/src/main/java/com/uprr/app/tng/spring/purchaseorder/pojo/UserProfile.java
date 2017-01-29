package com.uprr.app.tng.spring.purchaseorder.pojo;


public class UserProfile {
    private String customerId;
    private String customerName;
    private String customerEmailAddress;
    private String userPreferences;

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return this.customerName;
    }

    public void setCustomerName(final String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmailAddress() {
        return this.customerEmailAddress;
    }

    public void setCustomerEmailAddress(final String customerEmailAddress) {
        this.customerEmailAddress = customerEmailAddress;
    }

    public String getUserPreferences() {
        return this.userPreferences;
    }

    public void setUserPreferences(final String userPreferences) {
        this.userPreferences = userPreferences;
    }
}
