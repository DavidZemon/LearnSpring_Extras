package com.uprr.app.tng.spring.courseSchedule.service;

import com.uprr.app.tng.spring.courseSchedule.pojo.CourseDetails;
import com.uprr.app.tng.spring.courseSchedule.pojo.Schedule;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ScheduleBuilder {
    public List<Schedule> buildSchedules(final Map<String, List<CourseDetails>> courseDetails) {
        return this.pretendServiceCall(courseDetails);
    }

    private List<Schedule> pretendServiceCall(final Map<String, List<CourseDetails>> courseDetails) {
        final List<Schedule> schedules = new ArrayList<>();
        final Schedule       schedule  = new Schedule();
        schedule.setScheduleId(12);
        schedule.setCourseDetails(new CourseDetails());
        schedules.add(schedule);
        return schedules;
    }
}
