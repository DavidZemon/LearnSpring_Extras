package com.uprr.app.tng.spring.shoppinglist.service;

import com.uprr.app.tng.spring.shoppinglist.pojo.Ingredient;
import com.uprr.app.tng.spring.shoppinglist.pojo.Recipe;

import java.util.ArrayList;
import java.util.List;

public class GetIngredientsService {
    public GetIngredientsService() {
    }

    public List<Ingredient> getIngredients(final List<Recipe> recipes) {
        return this.pretendServiceCall(recipes);
    }

    private List<Ingredient> pretendServiceCall(final List<Recipe> recipes) {
        final List<Ingredient> ingredients = new ArrayList<>();
        ingredients.add(new Ingredient("apple", "4 large"));
        ingredients.add(new Ingredient("carrot", "2 large"));
        ingredients.add(new Ingredient("celery", "1 stalk"));
        ingredients.add(new Ingredient("onion", "41 large"));
        ingredients.add(new Ingredient("chicken broth", "2 cans"));
        ingredients.add(new Ingredient("egg noodles", "1.5 cups"));
        return ingredients;
    }
}
