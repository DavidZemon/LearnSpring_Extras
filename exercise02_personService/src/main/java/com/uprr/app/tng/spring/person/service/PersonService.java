package com.uprr.app.tng.spring.person.service;


import com.uprr.app.tng.spring.person.dao.PersonDao;
import com.uprr.app.tng.spring.person.exception.PersonDaoException;
import com.uprr.app.tng.spring.person.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class PersonService {
    @Autowired
    private PersonDao personDao;

    public Person getPerson(final String name) throws IOException {
        try {
            return this.personDao.get(name);
        } catch (final RuntimeException e) {
            throw new PersonDaoException("An error occurred while retrieving the person with name " + name, e);
        }
    }

}
