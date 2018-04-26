package com.recipapp.mapper;

import com.recipapp.controller.request.RecipeRequest;
import com.recipapp.model.Ingredient;
import com.recipapp.model.IngredientQuantity;
import com.recipapp.model.Recipe;

import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RecipeMapper extends AbstractObjectMapper<RecipeRequest, Recipe> {

    @Override
    public Recipe map(RecipeRequest recipeRequest, Class<Recipe> clazz) {
        Recipe recipe = new Recipe();
        recipe.setName(recipeRequest.getName());
        recipe.setDescription(recipeRequest.getDescription());
        recipe.setPhotos(recipeRequest.getPhotos());
        recipe.setSteps(recipeRequest.getSteps());
        recipe.setIngredients(recipeRequest.getIngredients().stream().map(creationRequestIngredientQuantity -> {
            IngredientQuantity ingredientQuantity = new IngredientQuantity();
            Ingredient ingredient = new Ingredient();
            ingredient.setId(creationRequestIngredientQuantity.getId());
            ingredientQuantity.setIngredient(ingredient);
            ingredientQuantity.setAmount(creationRequestIngredientQuantity.getAmount());
            ingredientQuantity.setMeasurement(creationRequestIngredientQuantity.getMeasurement());
            return ingredientQuantity;
        }).collect(Collectors.toList()));
        return recipe;
    }
}
