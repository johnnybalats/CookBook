package gr.codehub.cookbook.service;

import gr.codehub.cookbook.model.CookBook;

public class CookBookService {

    public  CookBook createCookBook() {

        CookBook cookBook = new CookBook("Recipes for beginners");
        RecipesListsService recipesListsService = new RecipesListsService();
        cookBook.getRecipes().addAll(recipesListsService.createEggRecipes());
        cookBook.getRecipes().addAll(recipesListsService.createVegetarianRecipes());

        return cookBook;
    }
}
