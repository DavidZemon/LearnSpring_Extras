package com.uprr.app.tng.spring.courseSchedule.config;

import com.uprr.app.tng.spring.courseSchedule.controller.CourseSchedulesController;
import com.uprr.app.tng.spring.courseSchedule.service.GetCourseDetailsService;
import com.uprr.app.tng.spring.courseSchedule.service.GetSchedulesService;
import com.uprr.app.tng.spring.courseSchedule.service.ScheduleBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MvcConfig.class)
public class CourseScheduleConfig {
    @Bean
    public GetCourseDetailsService getCourseDetailsService() {
        return new GetCourseDetailsService();
    }

    @Bean
    public ScheduleBuilder scheduleBuilder() {
        return new ScheduleBuilder();
    }

    @Bean
    public GetSchedulesService getSchedulesService() {
        return new GetSchedulesService(this.getCourseDetailsService(), this.scheduleBuilder());
    }

    @Bean
    public CourseSchedulesController courseSchedulesController() {
        return new CourseSchedulesController(this.getSchedulesService());
    }

}
