package com.uprr.app.tng.spring.studentrecords.pojo;

public class StudentRecord {
    private String studentName;
    private String studentId;
    private double gpa;
    private double loanAmount;

    public String getStudentName() {
        return this.studentName;
    }

    public void setStudentName(final String studentName) {
        this.studentName = studentName;
    }

    public String getStudentId() {
        return this.studentId;
    }

    public void setStudentId(final String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return this.gpa;
    }

    public void setGpa(final double gpa) {
        this.gpa = gpa;
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(final double loanAmount) {
        this.loanAmount = loanAmount;
    }
}
