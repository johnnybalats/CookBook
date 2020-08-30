package gr.codehub.cookbook.service;

import gr.codehub.cookbook.model.Recipe;

import java.util.ArrayList;
import java.util.List;

public class RecipesListsService {

    public List<Recipe> createEggRecipes() {

        RecipesService service = new RecipesService();
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(service.createOmeletteRecipe());
        recipes.add(service.createBoiledEggsRecipe());

        return recipes;
    }

    public List<Recipe> createVegetarianRecipes() {

        RecipesService service = new RecipesService();
        List<Recipe> recipes = new ArrayList<>();
        recipes.add(service.createGreekSaladRecipe());
        recipes.add(service.createSimplePastaRecipe());

        return recipes;
    }
}
