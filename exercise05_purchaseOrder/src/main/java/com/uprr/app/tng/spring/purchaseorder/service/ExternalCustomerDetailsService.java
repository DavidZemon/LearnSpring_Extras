package com.uprr.app.tng.spring.purchaseorder.service;

import com.uprr.app.tng.spring.purchaseorder.pojo.ExternalCustomerDetails;
import org.springframework.stereotype.Service;

@Service
public class ExternalCustomerDetailsService {
    public ExternalCustomerDetails getExternalCustomerDetails(final String customerId) {
        return this.pretendServiceCall(customerId);
    }

    private ExternalCustomerDetails pretendServiceCall(final String customerId) {
        final ExternalCustomerDetails externalCustomerDetails = new ExternalCustomerDetails();
        externalCustomerDetails.setCustomerId(customerId);
        externalCustomerDetails.setPreferredName("Bob");
        externalCustomerDetails.setVip(true);
        return externalCustomerDetails;
    }

}
