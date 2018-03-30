package com.recipapp.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;

@Data
public class IngredientQuantity {

    @DBRef
    private Ingredient ingredient;
    private Measurement measurement;
    private Integer amount;
}
