package com.uprr.app.tng.spring.shoppinglist.pojo;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

@SuppressWarnings("unused")
public class ShoppingList {
    @Nonnull private Collection<Ingredient> ingredients = Collections.emptyList();

    @Nonnull
    public Collection<Ingredient> getIngredients() {
        return Collections.unmodifiableCollection(this.ingredients);
    }

    public void setIngredients(@Nonnull final Collection<Ingredient> ingredients) {
        this.ingredients = Collections.unmodifiableCollection(ingredients);
    }
}
