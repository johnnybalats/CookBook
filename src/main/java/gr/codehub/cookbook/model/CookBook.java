package gr.codehub.cookbook.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class CookBook {

    private String title;
    private List<Recipe> recipes;

    public CookBook(String title) {

        this.title = title;
        recipes = new ArrayList<>();
    }
}
