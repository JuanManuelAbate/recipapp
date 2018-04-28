package com.recipapp.mapper;

import com.recipapp.controller.request.IngredientQuantityRequest;
import com.recipapp.controller.request.RecipeRequest;
import com.recipapp.model.Ingredient;
import com.recipapp.model.IngredientQuantity;
import com.recipapp.model.Recipe;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper extends AbstractObjectMapper<RecipeRequest, Recipe> {

    @Autowired
    private Mapper mapper;

    private static final Logger LOG = LoggerFactory.getLogger(RecipeMapper.class);

    @Override
    protected Logger getLogger() {
        return LOG;
    }

    @Override
    public Recipe doMap(RecipeRequest recipeRequest, Recipe output) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeRequest.getName());
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setPhotos(recipeRequest.getPhotos());
        recipe.setSteps(recipeRequest.getSteps());
        recipe.setIngredients(recipeRequest
            .getIngredients()
            .stream()
            .map(ingredientQuantity ->
                mapper.map(ingredientQuantity, IngredientQuantity.class))
            .collect(Collectors.toList()));
        return recipe;
    }
}
