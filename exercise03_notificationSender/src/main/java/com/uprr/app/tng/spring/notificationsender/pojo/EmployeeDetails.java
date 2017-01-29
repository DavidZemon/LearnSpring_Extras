package com.uprr.app.tng.spring.notificationsender.pojo;

public class EmployeeDetails {
    private String employeeId;
    private String firstName;
    private String lastName;
    private String position;
    private String userId;

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(final String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public String getPosition() {
        return this.position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }
}
