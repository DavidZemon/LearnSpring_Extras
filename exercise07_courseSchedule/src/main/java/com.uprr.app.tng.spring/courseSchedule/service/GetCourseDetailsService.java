package com.uprr.app.tng.spring.courseSchedule.service;

import com.uprr.app.tng.spring.courseSchedule.pojo.CourseDetails;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetCourseDetailsService {
    public Map<String, List<CourseDetails>> getCourseDetails(final List<String> courseNames) {
        return this.pretendServiceCall(courseNames);
    }

    private Map<String, List<CourseDetails>> pretendServiceCall(final List<String> courseNames) {
        final Map<String, List<CourseDetails>> courseDetailsMap = new HashMap<>();
        final List<CourseDetails>              historyOptions   = new ArrayList<>();
        historyOptions.add(this.buildCourseDetail("History", "MWF", "Birch", "10:00-11:00am"));
        historyOptions.add(this.buildCourseDetail("History", "TR", "Elm", "1:00-2:30pm"));
        courseDetailsMap.put("History", historyOptions);

        final List<CourseDetails> mathOptions = new ArrayList<>();
        mathOptions.add(this.buildCourseDetail("Math", "MWF", "Felina", "10:00-11:00am"));
        mathOptions.add(this.buildCourseDetail("Math", "TR", "Rowan", "1:00-2:30pm"));
        courseDetailsMap.put("Math", mathOptions);
        return courseDetailsMap;
    }

    private CourseDetails buildCourseDetail(final String courseName,
                                            final String daysOfWeek,
                                            final String professorName,
                                            final String time) {
        final CourseDetails courseDetails = new CourseDetails();
        courseDetails.setCourseName(courseName);
        courseDetails.setDaysOfWeek(daysOfWeek);
        courseDetails.setProfessor(professorName);
        courseDetails.setTimes(time);
        return courseDetails;
    }
}
