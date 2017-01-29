package com.uprr.app.tng.spring.courseSchedule.pojo;

public class Schedule {
    private int           scheduleId;
    private CourseDetails courseDetails;

    public int getScheduleId() {
        return this.scheduleId;
    }

    public void setScheduleId(final int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public CourseDetails getCourseDetails() {
        return this.courseDetails;
    }

    public void setCourseDetails(final CourseDetails courseDetails) {
        this.courseDetails = courseDetails;
    }
}
