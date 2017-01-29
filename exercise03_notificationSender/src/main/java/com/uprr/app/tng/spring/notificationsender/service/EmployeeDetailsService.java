package com.uprr.app.tng.spring.notificationsender.service;

import com.uprr.app.tng.spring.notificationsender.pojo.EmployeeDetails;

public class EmployeeDetailsService {
    public EmployeeDetails getUserDetails(final String employeeId) {
        return this.pretendServiceCall(employeeId);
    }

    private EmployeeDetails pretendServiceCall(final String employeeId) {
        // Here we are pretending to call a service
        final EmployeeDetails employeeDetails = new EmployeeDetails();
        employeeDetails.setEmployeeId(employeeId);
        employeeDetails.setUserId("EMP 456");
        employeeDetails.setPosition("Manager");
        employeeDetails.setFirstName("John");
        employeeDetails.setLastName("Smith");
        return employeeDetails;
    }
}
