package gr.codehub.cookbook.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Recipe {

    private String name;
    private List<Ingredient> ingredients;

    public Recipe(String name) {

        this.name = name;
        ingredients = new ArrayList<>();
    }

    public void addIngredient(Ingredient ingredient) {

        ingredients.add(ingredient);
    }
}
