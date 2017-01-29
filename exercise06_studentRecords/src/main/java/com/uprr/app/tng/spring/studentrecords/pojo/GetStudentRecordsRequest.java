package com.uprr.app.tng.spring.studentrecords.pojo;

import javax.annotation.Nonnull;

public class GetStudentRecordsRequest {
    private int maxNumberRecordsReturned;

    private SearchCriteria searchCriteria;

    public int getMaxNumberRecordsReturned() {
        return this.maxNumberRecordsReturned;
    }

    public void setMaxNumberRecordsReturned(final int maxNumberRecordsReturned) {
        this.maxNumberRecordsReturned = maxNumberRecordsReturned;
    }

    @Nonnull
    public SearchCriteria getSearchCriteria() {
        return this.searchCriteria;
    }

    public void setSearchCriteria(@Nonnull final SearchCriteria searchCriteria) {
        this.searchCriteria = searchCriteria;
    }
}
