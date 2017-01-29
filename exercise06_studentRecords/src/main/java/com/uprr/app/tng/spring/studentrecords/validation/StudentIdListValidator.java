package com.uprr.app.tng.spring.studentrecords.validation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StudentIdListValidator implements ConstraintValidator<StudentIdList, Number> {

    private long min;
    private long max;

    public void initialize(final StudentIdList constraint) {
        this.min = constraint.min();
        this.max = constraint.max();
    }

    public boolean isValid(@Nullable final Number candidate, @Nonnull final ConstraintValidatorContext context) {
        return null == candidate || (this.min <= candidate.longValue() && candidate.longValue() <= this.max);
    }
}
