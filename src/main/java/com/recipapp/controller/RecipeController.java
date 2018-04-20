package com.recipapp.controller;

import static com.recipapp.controller.ControllerTags.RECIPE_TAG;

import com.recipapp.controller.request.RecipeRequest;
import com.recipapp.controller.request.RecipeSearchRequest;
import com.recipapp.controller.response.SearchResponse;
import com.recipapp.mapper.Mapper;
import com.recipapp.model.Recipe;
import com.recipapp.service.RecipeService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private Mapper mapper;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new recipe with the given parameters", tags = RECIPE_TAG)
    public Recipe createRecipe(@RequestBody RecipeRequest recipeRequest) {
        return recipeService.save(mapper.map(recipeRequest, Recipe.class));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Searches the list of recipes that applyies to the given filters", tags = RECIPE_TAG)
    public SearchResponse<Recipe> searchRecipe(@Validated RecipeSearchRequest request) {
        return mapper.map(recipeService.searchRecipesByParams(request), SearchResponse.class);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the recipe for the given id", tags = RECIPE_TAG)
    public Recipe getRecipeById(@PathVariable Long id) {
        return recipeService.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the recipe for the given id", tags = RECIPE_TAG)
    public Recipe deleteRecipe(@PathVariable Long id) {
        return recipeService.delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the recipe for the given id", tags = RECIPE_TAG)
    public Recipe update(@PathVariable Long id, @RequestBody RecipeRequest recipeRequest) {
        return recipeService.update(mapper.map(recipeRequest, Recipe.class), id);
    }

}
