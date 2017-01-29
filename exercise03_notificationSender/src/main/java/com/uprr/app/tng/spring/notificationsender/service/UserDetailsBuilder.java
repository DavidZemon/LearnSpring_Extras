package com.uprr.app.tng.spring.notificationsender.service;

import com.uprr.app.tng.spring.notificationsender.pojo.EmployeeDetails;
import com.uprr.app.tng.spring.notificationsender.pojo.UserDetails;

public class UserDetailsBuilder {
    private final UserProfileService     userProfileService;
    private final EmployeeDetailsService employeeDetailsService;

    public UserDetailsBuilder(final UserProfileService userProfileService,
                              final EmployeeDetailsService employeeDetailsService) {
        this.userProfileService = userProfileService;
        this.employeeDetailsService = employeeDetailsService;
    }

    public UserDetails buildUserDetails(final String employeeId) {
        final EmployeeDetails employeeDetails = this.employeeDetailsService.getUserDetails(employeeId);
        return this.userProfileService.getUserDetails(employeeDetails.getUserId());
    }
}
