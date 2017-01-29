package com.uprr.app.tng.spring.purchaseorder.pojo;

public class ExternalCustomerDetails {
    private String  preferredName;
    private String  customerId;
    private boolean vip;

    public String getPreferredName() {
        return this.preferredName;
    }

    public void setPreferredName(final String preferredName) {
        this.preferredName = preferredName;
    }

    public String getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(final String customerId) {
        this.customerId = customerId;
    }

    public boolean isVip() {
        return this.vip;
    }

    public void setVip(final boolean vip) {
        this.vip = vip;
    }
}
