package com.recipapp.mapper;

import com.recipapp.controller.request.IngredientRequest;
import com.recipapp.model.Ingredient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class IngredientMapper extends AbstractObjectMapper<IngredientRequest, Ingredient> {

    private static final Logger LOG = LoggerFactory.getLogger(IngredientMapper.class);

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    public Ingredient doMap(IngredientRequest ingredientRequest, Ingredient ingredient) {
        ingredient.setName(ingredientRequest.getName());
        return ingredient;
    }
}