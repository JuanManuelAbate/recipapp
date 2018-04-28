package com.recipapp.mapper;

import com.recipapp.controller.request.IngredientQuantityRequest;
import com.recipapp.controller.request.RecipeRequest;
import com.recipapp.model.Ingredient;
import com.recipapp.model.IngredientQuantity;
import com.recipapp.model.Recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IngredientQuantityMapper extends AbstractObjectMapper<IngredientQuantityRequest, IngredientQuantity> {

    private static final Logger LOG = LoggerFactory.getLogger(IngredientQuantityMapper.class);

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    public IngredientQuantity doMap(IngredientQuantityRequest input, IngredientQuantity ingredientQuantity) {
        Ingredient ingredient = new Ingredient();
        ingredient.setId(input.getId());
        ingredientQuantity.setIngredient(ingredient);
        ingredientQuantity.setAmount(input.getAmount());
        ingredientQuantity.setMeasurement(input.getMeasurement());
        return ingredientQuantity;
    }
}
