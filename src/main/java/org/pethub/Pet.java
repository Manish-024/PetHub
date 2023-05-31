package org.pethub;

public class Pet {
    private String name;
    private String species;
    private int age;
    private String favoriteFood;

    public Pet(String name, String species, int age, String favoriteFood) {
        this.name = name;
        this.species = species;
        this.age = age;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public int getAge() {
        return age;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }
}
