package com.recipapp.model;

import lombok.Data;

@Data
public class IngredientQuantity {

    private Ingredient ingredient;
    private Measurement measurement;
    private Integer amount;
}
