package com.uprr.app.tng.spring.person.exception;

public class PersonDaoException extends RuntimeException {
    private static final long serialVersionUID = -7843713815177077813L;

    public PersonDaoException(final String message, final Throwable e) {
        super(message, e);
    }
}
