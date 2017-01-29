package com.uprr.app.tng.spring.shoppinglist.config;

import com.uprr.app.tng.spring.shoppinglist.controller.ShoppingListController;
import com.uprr.app.tng.spring.shoppinglist.service.GetIngredientsService;
import com.uprr.app.tng.spring.shoppinglist.service.GetRecipesService;
import com.uprr.app.tng.spring.shoppinglist.service.GetShoppingListService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(MvcConfig.class)
public class ShoppingListMainConfig {
    @Bean
    public GetRecipesService getRecipesService() {
        return new GetRecipesService();
    }

    @Bean
    public GetIngredientsService getIngredientsService() {
        return new GetIngredientsService();
    }

    @Bean
    public GetShoppingListService getShoppingListService() {
        return new GetShoppingListService(this.getRecipesService(), this.getIngredientsService());
    }

    @Bean
    public ShoppingListController shoppingListController () {
        return new ShoppingListController(this.getShoppingListService());
    }
}
