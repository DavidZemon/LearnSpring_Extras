package com.uprr.app.tng.spring.courseSchedule.controller.advice;

import com.uprr.app.tng.spring.courseSchedule.pojo.ClientError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.annotation.Nonnull;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ClientError handleBadRequestException(@Nonnull
                                                 final MethodArgumentNotValidException e) {
        final BindingResult bindingResult = e.getBindingResult();
        if (bindingResult.getErrorCount() == 1) {
            return new ClientError("Bad request", bindingResult.getFieldError().getDefaultMessage());
        } else {
            final String combinedErrors = bindingResult.getFieldErrors().stream()
                    .map(DefaultMessageSourceResolvable::getDefaultMessage)
                    .reduce((e1, e2) -> e1 + ", " + e2)
                    .orElse("");
            return new ClientError("Bad request", String.format("Multiple errors: [%s]", combinedErrors));
        }
    }

}
