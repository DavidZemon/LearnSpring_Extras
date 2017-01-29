package com.uprr.app.tng.spring.courseSchedule.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uprr.app.tng.spring.courseSchedule.controller.advice.GlobalExceptionHandler;
import com.uprr.app.tng.spring.courseSchedule.exception.CourseDetailsNotFoundException;
import com.uprr.app.tng.spring.courseSchedule.service.GetSchedulesService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(MockitoJUnitRunner.class)
public class CourseSchedulesControllerIT {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mock
    private GetSchedulesService getSchedulesService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(new CourseSchedulesController(this.getSchedulesService))
            .setControllerAdvice(new GlobalExceptionHandler())
            .build();
    }

    @Test
    public void test_get() throws Exception {
        final List<String> courseNames   = Arrays.asList("Spring", "Maven");
        final String       requestString = OBJECT_MAPPER.writeValueAsString(courseNames);

        final MvcResult result = this.mockMvc.perform(post("/schedules/get")
                                                          .accept(MediaType.APPLICATION_JSON)
                                                          .contentType(MediaType.APPLICATION_JSON)
                                                          .content(requestString))
                                             .andExpect(status().is(HttpStatus.OK.value()))
                                             .andReturn();
        final String contentAsString = result.getResponse().getContentAsString();
        assertEquals("Response status code was not Ok. Response was " + contentAsString,
                     HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void test_get_courseDetailsNotFound() throws Exception {
        final List<String> courseNames   = Collections.singletonList("JavaEE");
        final String       requestString = OBJECT_MAPPER.writeValueAsString(courseNames);

        when(this.getSchedulesService.getSchedules(any())).thenThrow(
            new CourseDetailsNotFoundException("No course details were found for the given request."));
        this.mockMvc.perform(post("/schedules/get")
                                 .accept(MediaType.APPLICATION_JSON)
                                 .contentType(MediaType.APPLICATION_JSON)
                                 .content(requestString))
                    .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
                    .andExpect(jsonPath("$.title", is("Course Details Not Found")))
                    .andExpect(jsonPath("$.message", is("No course details were found for the given request.")));
    }


}
