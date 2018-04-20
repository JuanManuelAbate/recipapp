package com.recipapp.controller.request;

import com.recipapp.model.Measurement;

import lombok.Data;

@Data
public class RecipeRequestIngredientQuantity {

    private Long id;
    private Measurement measurement;
    private Integer amount;
}
