package org.pethub;

public class Food {
    private String name;
    private String description;
    private int nutritionalValue;

    public Food(String name, String description, int nutritionalValue) {
        this.name = name;
        this.description = description;
        this.nutritionalValue = nutritionalValue;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getNutritionalValue() {
        return nutritionalValue;
    }
}
