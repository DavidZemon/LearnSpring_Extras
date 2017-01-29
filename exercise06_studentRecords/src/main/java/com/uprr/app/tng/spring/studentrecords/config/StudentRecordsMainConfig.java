package com.uprr.app.tng.spring.studentrecords.config;

import com.uprr.app.tng.spring.studentrecords.controller.StudentRecordsController;
import com.uprr.app.tng.spring.studentrecords.service.GetStudentRecordsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MvcConfig.class)
public class StudentRecordsMainConfig {
    @Bean
    public GetStudentRecordsService getStudentRecordsService() {
        return new GetStudentRecordsService();
    }

    @Bean
    public StudentRecordsController studentRecordsController() {
        return new StudentRecordsController(this.getStudentRecordsService());
    }

}
