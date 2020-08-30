package gr.codehub.cookbook.service;

import gr.codehub.cookbook.model.Ingredient;
import gr.codehub.cookbook.model.Recipe;

public class RecipesService {

    public Recipe createOmeletteRecipe() {

        Recipe recipe = new Recipe("Omelette");
        recipe.addIngredient(new Ingredient("egg", 2));
        recipe.addIngredient(new Ingredient("milk", 50));
        recipe.addIngredient(new Ingredient("cheese", 200));
        recipe.addIngredient(new Ingredient("bacon", 2));
        return recipe;
    }

    public Recipe createBoiledEggsRecipe() {

        Recipe recipe = new Recipe("Boiled eggs");
        recipe.addIngredient(new Ingredient("egg", 2));
        return recipe;
    }

    public Recipe createSimplePastaRecipe(){
        Recipe recipe = new Recipe("Simple pasta");
        recipe.addIngredient(new Ingredient("macaroni", 150));
        recipe.addIngredient(new Ingredient("olive oil", 50));
        return recipe;
    }

    public Recipe createGreekSaladRecipe(){
        Recipe recipe = new Recipe("Greek salad");
        recipe.addIngredient(new Ingredient("tomato", 2));
        recipe.addIngredient(new Ingredient("cucumber", 2));
        recipe.addIngredient(new Ingredient("olive oil", 100));
        recipe.addIngredient(new Ingredient("feta", 200));
        return recipe;
    }
}
