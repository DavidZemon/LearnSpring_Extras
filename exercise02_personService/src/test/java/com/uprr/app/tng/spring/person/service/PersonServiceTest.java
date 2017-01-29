package com.uprr.app.tng.spring.person.service;

import com.uprr.app.tng.spring.person.pojo.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-context.xml")
public class PersonServiceTest {

    @Inject
    private PersonService personService;

    @Test
    public void test_getDavid() throws Exception {
        final Person person = this.personService.getPerson("david");
        assertEquals("awesome", person.getAttribute());
        assertEquals(8, person.getAttributeLevel().intValue());
    }

    @Test
    public void test_getKatie() throws Exception {
        final Person person = this.personService.getPerson("katie");
        assertEquals("supertastic", person.getAttribute());
        assertEquals(10, person.getAttributeLevel().intValue());
    }

    @Test
    public void test_getJosh() throws Exception {
        final Person person = this.personService.getPerson("josh");
        assertEquals("fantasmal", person.getAttribute());
        assertEquals(9, person.getAttributeLevel().intValue());
    }
}
