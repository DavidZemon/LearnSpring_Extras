package com.uprr.app.tng.spring.purchaseorder.service;

import com.uprr.app.tng.spring.purchaseorder.pojo.CustomerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerDetailsService {
    @Autowired
    private ExternalCustomerDetailsService externalCustomerDetailsService;
    @Autowired
    private UserProfileService             userProfileService;


    public CustomerDetails getCustomerDetails(final String customerId) {

        final CustomerDetails customerDetails = new CustomerDetails();
        customerDetails.setUserProfile(this.userProfileService.getUserProfile(customerId));
        customerDetails.setExternalCustomerDetails(
            this.externalCustomerDetailsService.getExternalCustomerDetails(customerId));
        return customerDetails;

    }
}
