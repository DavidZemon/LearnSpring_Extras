package com.uprr.app.tng.spring.courseSchedule.service;

import com.uprr.app.tng.spring.courseSchedule.pojo.CourseDetails;
import com.uprr.app.tng.spring.courseSchedule.pojo.Schedule;

import java.util.List;
import java.util.Map;

public class GetSchedulesService {
    private final GetCourseDetailsService getCourseDetailsService;
    private final ScheduleBuilder         scheduleBuilder;

    public GetSchedulesService(
        final GetCourseDetailsService getCourseDetailsService,
        final ScheduleBuilder scheduleBuilder) {
        this.getCourseDetailsService = getCourseDetailsService;
        this.scheduleBuilder = scheduleBuilder;
    }

    public List<Schedule> getSchedules(final List<String> courseNames) {
        final Map<String, List<CourseDetails>> courseDetails = this.getCourseDetailsService.getCourseDetails(courseNames);
        return this.scheduleBuilder.buildSchedules(courseDetails);
    }

}
