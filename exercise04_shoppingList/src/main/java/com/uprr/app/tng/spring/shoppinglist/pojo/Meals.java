package com.uprr.app.tng.spring.shoppinglist.pojo;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;

public class Meals {

    @Nonnull private Collection<Meal> meals = Collections.emptyList();

    @Nonnull
    public Collection<Meal> getMeals() {
        return Collections.unmodifiableCollection(this.meals);
    }

    public void setMeals(@Nonnull final Collection<Meal> meals) {
        this.meals = Collections.unmodifiableCollection(meals);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        final Meals meals1 = (Meals) o;

        return new EqualsBuilder()
                .append(this.meals, meals1.meals)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(this.meals)
                .toHashCode();
    }
}
