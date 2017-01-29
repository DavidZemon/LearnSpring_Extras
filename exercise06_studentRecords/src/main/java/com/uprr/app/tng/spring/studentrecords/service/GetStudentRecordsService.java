package com.uprr.app.tng.spring.studentrecords.service;

import com.uprr.app.tng.spring.studentrecords.pojo.GetStudentRecordsRequest;
import com.uprr.app.tng.spring.studentrecords.pojo.StudentRecord;

import java.util.ArrayList;
import java.util.List;

public class GetStudentRecordsService {

    public List<StudentRecord> getStudentRecords(final GetStudentRecordsRequest getStudentRecordsRequest) {
        return this.pretendDatabaseCall(getStudentRecordsRequest);
    }

    private List<StudentRecord> pretendDatabaseCall(final GetStudentRecordsRequest getStudentRecordsRequest) {
        final StudentRecord studentRecord = new StudentRecord();
        studentRecord.setGpa(3.78);
        studentRecord.setLoanAmount(142864.23);
        studentRecord.setStudentId("ISD3951");
        final List<StudentRecord> studentRecords = new ArrayList<>();
        studentRecords.add(studentRecord);
        return studentRecords;
    }


}
