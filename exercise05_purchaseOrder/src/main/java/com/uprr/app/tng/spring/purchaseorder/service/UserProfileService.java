package com.uprr.app.tng.spring.purchaseorder.service;


import com.uprr.app.tng.spring.purchaseorder.pojo.UserProfile;
import org.springframework.stereotype.Service;

@Service
public class UserProfileService {
    public UserProfile getUserProfile(final String customerId) {
        return this.pretendServiceCall(customerId);
    }

    private UserProfile pretendServiceCall(final String customerId) {
        final UserProfile userProfile = new UserProfile();
        userProfile.setCustomerId(customerId);
        userProfile.setCustomerName("John Smith");
        userProfile.setCustomerEmailAddress("johnsmith@gmail.com");
        return userProfile;
    }

}
