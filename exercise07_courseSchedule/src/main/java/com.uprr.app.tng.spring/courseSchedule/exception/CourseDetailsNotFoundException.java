package com.uprr.app.tng.spring.courseSchedule.exception;

public class CourseDetailsNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1176828831689693801L;

    public CourseDetailsNotFoundException(final String errorMessage) {
        super(errorMessage);
    }
}
