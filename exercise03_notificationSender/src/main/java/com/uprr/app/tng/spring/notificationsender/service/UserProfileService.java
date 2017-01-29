package com.uprr.app.tng.spring.notificationsender.service;

import com.uprr.app.tng.spring.notificationsender.pojo.UserDetails;

public class UserProfileService {
    public UserDetails getUserDetails(final String userId) {
        return this.pretendServiceCall(userId);
    }

    private UserDetails pretendServiceCall(final String userId) {
        // Here we are pretending to call a service
        final UserDetails userDetails = new UserDetails();
        userDetails.setUserId(userId);
        userDetails.setEmailAddress("JohnSmith@gmail.com");
        userDetails.setFirstName("John");
        userDetails.setLastName("Smith");
        userDetails.setHomeAddress("555 Street Nashville, TN");
        return userDetails;
    }
}
