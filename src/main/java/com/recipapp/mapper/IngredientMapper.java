package com.recipapp.mapper;

import com.recipapp.controller.request.IngredientRequest;
import com.recipapp.model.Ingredient;

import org.springframework.stereotype.Component;

@Component
public class IngredientMapper extends AbstractObjectMapper<IngredientRequest, Ingredient> {

    @Override
    public Ingredient map(IngredientRequest ingredientRequest, Class<Ingredient> clazz) {
        Ingredient ingredient = new Ingredient();
        ingredient.setName(ingredientRequest.getName());
        return ingredient;
    }
}