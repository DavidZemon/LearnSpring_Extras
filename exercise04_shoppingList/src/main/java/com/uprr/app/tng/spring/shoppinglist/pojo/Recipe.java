package com.uprr.app.tng.spring.shoppinglist.pojo;

public class Recipe {
    private int id;
    private String instructions;

    public int getId() {
        return this.id;
    }

    public void setId(final int id) {
        this.id = id;
    }

    public String getInstructions() {
        return this.instructions;
    }

    public void setInstructions(final String instructions) {
        this.instructions = instructions;
    }
}
