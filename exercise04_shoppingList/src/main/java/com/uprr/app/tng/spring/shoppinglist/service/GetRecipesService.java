package com.uprr.app.tng.spring.shoppinglist.service;

import com.uprr.app.tng.spring.shoppinglist.pojo.Meals;
import com.uprr.app.tng.spring.shoppinglist.pojo.Recipe;

import java.util.ArrayList;
import java.util.List;

public class GetRecipesService {
    public GetRecipesService() {
    }

    public List<Recipe> getRecipes(final Meals meals) {
        return this.pretendServiceCall(meals);
    }

    private List<Recipe> pretendServiceCall(final Meals meals) {
        final List<Recipe> recipes    = new ArrayList<>();
        final Recipe       appleSauce = new Recipe();
        appleSauce.setId(1);
        appleSauce.setInstructions("" +
                "Sautee 4 large apples, 1/4 cup water, 1/4 cup white sugar, 1/2 tspn cinnamon " +
                "on medium low heat for 10 minutes. Mash when done.");
        recipes.add(appleSauce);

        final Recipe chickenNoodleSoup = new Recipe();
        chickenNoodleSoup.setId(2);
        chickenNoodleSoup.setInstructions("" +
                "Sautee 2 carrots, 1 stalk celery, and 1 onion in large pot. Add two 15 oz cans chicken broth " +
                "and boil 20 minutes. Add chicken with black pepper, oregano, basil and cook 5 more minutes." +
                " Add egg noodles and serve when done.");
        recipes.add(chickenNoodleSoup);

        return recipes;
    }
}
