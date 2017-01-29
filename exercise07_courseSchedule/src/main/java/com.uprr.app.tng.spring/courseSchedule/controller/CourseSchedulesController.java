package com.uprr.app.tng.spring.courseSchedule.controller;

import com.uprr.app.tng.spring.courseSchedule.pojo.Schedule;
import com.uprr.app.tng.spring.courseSchedule.service.GetSchedulesService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("get")
public class CourseSchedulesController {
    private final GetSchedulesService getSchedulesService;

    public CourseSchedulesController(final GetSchedulesService getSchedulesService) {
        this.getSchedulesService = getSchedulesService;
    }

    @RequestMapping(value = "schedules",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Schedule> getSchedules(@RequestBody final List<String> courseNames) {
        return this.getSchedulesService.getSchedules(courseNames);
    }
}
