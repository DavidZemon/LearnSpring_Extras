package com.uprr.app.tng.spring.shoppinglist.service;

import com.uprr.app.tng.spring.shoppinglist.pojo.Ingredient;
import com.uprr.app.tng.spring.shoppinglist.pojo.Meals;
import com.uprr.app.tng.spring.shoppinglist.pojo.Recipe;
import com.uprr.app.tng.spring.shoppinglist.pojo.ShoppingList;

import javax.annotation.Nonnull;
import java.util.List;

public class GetShoppingListService {
    @Nonnull private final GetRecipesService getRecipesService;
    @Nonnull private final GetIngredientsService getIngredientsService;

    public GetShoppingListService(@Nonnull final GetRecipesService getRecipesService,
                                  @Nonnull final GetIngredientsService getIngredientsService) {
        this.getRecipesService = getRecipesService;
        this.getIngredientsService = getIngredientsService;
    }

    public ShoppingList getShoppingList(final Meals meals) {
        final List<Recipe>     recipes     = this.getRecipesService.getRecipes(meals);
        final List<Ingredient> ingredients = this.getIngredientsService.getIngredients(recipes);
        return this.buildReply(ingredients);
    }

    private ShoppingList buildReply(final List<Ingredient> ingredients) {
        final ShoppingList shoppingList = new ShoppingList();
        shoppingList.setIngredients(ingredients);
        return shoppingList;
    }
}
