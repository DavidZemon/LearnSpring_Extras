package com.uprr.app.tng.spring.shoppinglist.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.uprr.app.tng.spring.shoppinglist.config.ShoppingListMainConfig;
import com.uprr.app.tng.spring.shoppinglist.pojo.Meal;
import com.uprr.app.tng.spring.shoppinglist.pojo.Meals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ShoppingListMainConfig.class)
@WebAppConfiguration
public class ShoppingListControllerIT {
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Inject
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void test_get() throws Exception {
        final Meals  meals         = this.buildRequest();
        final String requestString = OBJECT_MAPPER.writeValueAsString(meals);

        final MvcResult result = this.mockMvc.perform(post("/shoppingList/get")
                                                          .accept(MediaType.APPLICATION_JSON)
                                                          .contentType(MediaType.APPLICATION_JSON)
                                                          .content(requestString))
                                             .andExpect(status().is(HttpStatus.OK.value()))
                                             .andReturn();
        final String contentAsString = result.getResponse().getContentAsString();
        assertEquals("Response status code was not Ok. Response was " + contentAsString,
                     HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    private Meals buildRequest() {
        final List<Meal> mealsList = new ArrayList<>();
        mealsList.add(new Meal(1, "applesauce"));
        mealsList.add(new Meal(2, "chicken noodle soup"));
        final Meals meals = new Meals();
        meals.setMeals(mealsList);
        return meals;
    }
}
