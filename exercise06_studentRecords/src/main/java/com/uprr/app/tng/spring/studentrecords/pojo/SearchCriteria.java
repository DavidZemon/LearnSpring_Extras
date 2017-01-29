package com.uprr.app.tng.spring.studentrecords.pojo;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

public class SearchCriteria {
    private double GPA;

    @Nonnull
    private Collection<String> studentIds = Collections.emptyList();

    private double loanAmount;

    public double getGPA() {
        return this.GPA;
    }

    public void setGPA(final double GPA) {
        this.GPA = GPA;
    }

    @Nonnull
    public Collection<String> getStudentIds() {
        return Collections.unmodifiableCollection(this.studentIds);
    }

    public void setStudentIds(@Nonnull final Collection<String> studentIds) {
        this.studentIds = Collections.unmodifiableCollection(studentIds);
    }

    public double getLoanAmount() {
        return this.loanAmount;
    }

    public void setLoanAmount(final double loanAmount) {
        this.loanAmount = loanAmount;
    }
}
