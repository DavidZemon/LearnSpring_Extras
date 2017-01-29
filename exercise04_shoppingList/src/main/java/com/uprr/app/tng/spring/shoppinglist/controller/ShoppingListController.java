package com.uprr.app.tng.spring.shoppinglist.controller;

import com.uprr.app.tng.spring.shoppinglist.pojo.Meals;
import com.uprr.app.tng.spring.shoppinglist.pojo.ShoppingList;
import com.uprr.app.tng.spring.shoppinglist.service.GetShoppingListService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nonnull;

@Controller
@RequestMapping("shoppingList")
public class ShoppingListController {
    @Nonnull
    private final GetShoppingListService getShoppingListService;

    public ShoppingListController(@Nonnull final GetShoppingListService getShoppingListService) {
        this.getShoppingListService = getShoppingListService;
    }

    @RequestMapping(value = "get",
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ShoppingList getShoppingList(@RequestBody final Meals meals) {
        return this.getShoppingListService.getShoppingList(meals);
    }
}
