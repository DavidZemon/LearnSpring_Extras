package com.uprr.app.tng.spring.shoppinglist.pojo;

public class Ingredient {
    private String name;
    private String amount;

    public Ingredient(final String name, final String amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getAmount() {
        return this.amount;
    }

    public void setAmount(final String amount) {
        this.amount = amount;
    }

}
