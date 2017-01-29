package com.uprr.app.tng.spring.shoppinglist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uprr.app.tng.spring.studentrecords.controller.StudentRecordsController;
import com.uprr.app.tng.spring.studentrecords.controller.advice.GlobalExceptionHandler;
import com.uprr.app.tng.spring.studentrecords.pojo.GetStudentRecordsRequest;
import com.uprr.app.tng.spring.studentrecords.pojo.SearchCriteria;
import com.uprr.app.tng.spring.studentrecords.service.GetStudentRecordsService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class StudentRecordsControllerIT {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Mock
    private GetStudentRecordsService getStudentRecordsService;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders
            .standaloneSetup(new StudentRecordsController(this.getStudentRecordsService))
            .setControllerAdvice(new GlobalExceptionHandler())
            .build();
    }

    @Test
    public void test_get_validRequest() throws Exception {
        final GetStudentRecordsRequest request       = this.buildValidRequest();
        final ResultActions            resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.OK.value()));
    }

    @Test
    public void test_get_invalidMaxNumRecords_isZero() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.setMaxNumberRecordsReturned(0);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("Max Number of Records must be greater than or equal to 1.")));
    }

    @Test
    public void test_get_invalidMaxNumRecords_isNegative() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.setMaxNumberRecordsReturned(-5);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("Max Number of Records must be greater than or equal to 1.")));
    }

    @Test
    public void test_get_invalidSearchCriteria_isNull() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.setSearchCriteria(null);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("Search criteria is required in the request.")));
    }

    @Test
    public void test_get_invalidLoanAmount_isNegative() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.getSearchCriteria().setLoanAmount(-6000.52);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("Loan amount must be greater than zero.")));
    }

    @Test
    public void test_get_invalidLoanAmount_tooManyDigitsAfterDecimal() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.getSearchCriteria().setLoanAmount(6000.523);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("Loan amount can only have 2 digits after the decimal.")));
    }

    @Test
    public void test_get_invalidGpa_tooSmall() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.getSearchCriteria().setGPA(-1);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("GPA must be between 0 and 4.0.")));
    }

    @Test
    public void test_get_invalidGpa_tooLarge() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.getSearchCriteria().setGPA(5);
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("GPA must be between 0 and 4.0.")));
    }

    @Test
    public void test_get_tooManyStudentIds() throws Exception {
        final GetStudentRecordsRequest request = this.buildValidRequest();
        request.getSearchCriteria().setStudentIds(this.getValidStudentIds());
        final ResultActions resultActions = this.getStudentRecords(request);
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("Student Id list must have 10 or fewer elements.")));
    }


    @Test
    public void test_get_invalidStudentId_noDigits() throws Exception {
        final SearchCriteria searchCriteria = this.buildValidSearchCriteria();
        searchCriteria.setStudentIds(Collections.singletonList("ABC"));

        final ResultActions resultActions = this.getStudentRecords(this.buildValidRequest(searchCriteria));
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("One or more student Ids was invalid. Student Id must " +
                                                             "match the pattern [a-zA-Z]{2,4}\\d{3,6}")));
    }

    @Test
    public void test_get_invalidStudentId_tooManyLetters() throws Exception {
        final SearchCriteria searchCriteria = this.buildValidSearchCriteria();
        searchCriteria.setStudentIds(Collections.singletonList("ABCDEFG12"));

        final ResultActions resultActions = this.getStudentRecords(this.buildValidRequest(searchCriteria));
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("One or more student Ids was invalid. Student Id must " +
                                                             "match the pattern [a-zA-Z]{2,4}\\d{3,6}")));
    }

    @Test
    public void test_get_invalidStudentId_noLetters() throws Exception {
        final SearchCriteria searchCriteria = this.buildValidSearchCriteria();
        searchCriteria.setStudentIds(Collections.singletonList("123"));

        final ResultActions resultActions = this.getStudentRecords(this.buildValidRequest(searchCriteria));
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("One or more student Ids was invalid. Student Id must " +
                                                             "match the pattern [a-zA-Z]{2,4}\\d{3,6}")));

    }

    @Test
    public void test_get_invalidStudentId_strangeCharacters() throws Exception {
        final SearchCriteria searchCriteria = this.buildValidSearchCriteria();
        searchCriteria.setStudentIds(Collections.singletonList("$QP09"));

        final ResultActions resultActions = this.getStudentRecords(this.buildValidRequest(searchCriteria));
        resultActions.andExpect(status().is(HttpStatus.BAD_REQUEST.value()));
        resultActions.andExpect(jsonPath("$.message", is("One or more student Ids was invalid. Student Id must " +
                                                             "match the pattern [a-zA-Z]{2,4}\\d{3,6}")));
    }

    @Nonnull
    private ResultActions getStudentRecords(@Nonnull final GetStudentRecordsRequest request) throws Exception {
        return this.mockMvc.perform(
            post("/studentRecords/get")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(OBJECT_MAPPER.writeValueAsString(request)));
    }

    @Nonnull
    private GetStudentRecordsRequest buildValidRequest() {
        final GetStudentRecordsRequest request = new GetStudentRecordsRequest();
        request.setMaxNumberRecordsReturned(30);
        request.setSearchCriteria(this.buildValidSearchCriteria());
        return request;
    }

    @Nonnull
    private GetStudentRecordsRequest buildValidRequest(@Nonnull final SearchCriteria searchCriteria) {
        final GetStudentRecordsRequest request = new GetStudentRecordsRequest();
        request.setMaxNumberRecordsReturned(30);
        request.setSearchCriteria(searchCriteria);
        return request;
    }

    @Nonnull
    private SearchCriteria buildValidSearchCriteria() {
        final SearchCriteria searchCriteria = new SearchCriteria();
        searchCriteria.setGPA((float) 4.0);
        searchCriteria.setStudentIds(Arrays.asList("STU345", "EXMC123", "PDW9923"));
        searchCriteria.setLoanAmount(93000);
        return searchCriteria;
    }

    @Nonnull
    private Collection<String> getValidStudentIds() {
        return Arrays.asList(
            "GKS245", "MDJ0392", "JBE0598",
            "DKAE0598", "JAS4242", "PWQM5428",
            "DNS3423", "UNXM9712", "UMR920",
            "JKL982", "HSQ9234", "MNSW8695"
        );
    }
}
