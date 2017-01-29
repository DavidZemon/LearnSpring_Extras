package com.uprr.app.tng.spring.studentrecords.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({
    FIELD,
    PARAMETER,
    METHOD,
    ANNOTATION_TYPE,
    LOCAL_VARIABLE
})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StudentIdListValidator.class)
@Documented
public @interface StudentIdList {
    String message() default "Value is out of range";

    /**
     * Minimum allowed value
     */
    long min();

    /**
     * Maximum allowed value
     */
    long max();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
