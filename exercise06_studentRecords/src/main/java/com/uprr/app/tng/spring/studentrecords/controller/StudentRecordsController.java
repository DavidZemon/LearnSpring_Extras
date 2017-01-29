package com.uprr.app.tng.spring.studentrecords.controller;

import com.uprr.app.tng.spring.studentrecords.pojo.GetStudentRecordsRequest;
import com.uprr.app.tng.spring.studentrecords.pojo.StudentRecord;
import com.uprr.app.tng.spring.studentrecords.service.GetStudentRecordsService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("studentRecords")
public class StudentRecordsController {
    private final GetStudentRecordsService getStudentRecordsService;

    public StudentRecordsController(final GetStudentRecordsService getStudentRecordsService) {
        this.getStudentRecordsService = getStudentRecordsService;
    }

    @RequestMapping(value = "get",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<StudentRecord> getStudentRecords(@RequestBody final GetStudentRecordsRequest request) {
        return this.getStudentRecordsService.getStudentRecords(request);
    }
}
