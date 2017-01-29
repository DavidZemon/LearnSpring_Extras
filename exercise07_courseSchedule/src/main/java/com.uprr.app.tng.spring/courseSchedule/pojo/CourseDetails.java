package com.uprr.app.tng.spring.courseSchedule.pojo;

public class CourseDetails {
    private String professor;
    private String daysOfWeek;
    private String times;
    private String courseName;

    public String getProfessor() {
        return this.professor;
    }

    public void setProfessor(final String professor) {
        this.professor = professor;
    }

    public String getDaysOfWeek() {
        return this.daysOfWeek;
    }

    public void setDaysOfWeek(final String daysOfWeek) {
        this.daysOfWeek = daysOfWeek;
    }

    public String getTimes() {
        return this.times;
    }

    public void setTimes(final String times) {
        this.times = times;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void setCourseName(final String courseName) {
        this.courseName = courseName;
    }
}
