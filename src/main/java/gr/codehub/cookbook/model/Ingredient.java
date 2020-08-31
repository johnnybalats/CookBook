package gr.codehub.cookbook.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient implements Serializable {

    private String name;
    private double quantity;
}
