package com.uprr.app.tng.spring.purchaseorder.pojo;

public class CustomerDetails {
    private ExternalCustomerDetails externalCustomerDetails;
    private UserProfile userProfile;

    public ExternalCustomerDetails getExternalCustomerDetails() {
        return this.externalCustomerDetails;
    }

    public void setExternalCustomerDetails(
        final ExternalCustomerDetails externalCustomerDetails) {
        this.externalCustomerDetails = externalCustomerDetails;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(final UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
