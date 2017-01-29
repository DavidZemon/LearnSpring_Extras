package com.uprr.app.tng.spring.purchaseorder.pojo;

public class OrderDetails {
    private SomeOrderDetails someOrderDetails;
    private CustomerDetails customerDetails;

    public SomeOrderDetails getSomeOrderDetails() {
        return this.someOrderDetails;
    }

    public void setSomeOrderDetails(final SomeOrderDetails someOrderDetails) {
        this.someOrderDetails = someOrderDetails;
    }

    public CustomerDetails getCustomerDetails() {
        return this.customerDetails;
    }

    public void setCustomerDetails(final CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
    }
}
