package com.recipapp.controller;

import static com.recipapp.controller.ControllerTags.RECIPE_TAG;

import com.recipapp.controller.request.RecipeSearchRequest;
import com.recipapp.controller.response.SearchResponse;
import com.recipapp.mapper.Mapper;
import com.recipapp.model.Recipe;
import com.recipapp.service.RecipeService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public Recipe createRecipe(@RequestBody Recipe recipe) {
        return recipeService.save(recipe);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ApiOperation(value = "Searches the list of recipes that applyies to the given filters", tags = RECIPE_TAG)
    public SearchResponse<Recipe> searchRecipe(@Validated RecipeSearchRequest request) {
        return mapper.map(recipeService.searchRecipesByParams(request), SearchResponse.class);
    }

}
