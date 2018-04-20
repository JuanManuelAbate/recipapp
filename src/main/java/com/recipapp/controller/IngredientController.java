package com.recipapp.controller;

import static com.recipapp.controller.ControllerTags.INGREDIENT_TAG;

import com.recipapp.controller.request.IngredientRequest;
import com.recipapp.mapper.Mapper;
import com.recipapp.model.Ingredient;
import com.recipapp.service.IngredientService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
public class IngredientController {

    @Autowired
    IngredientService ingredientService;

    @Autowired
    private Mapper mapper;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new ingredient with the given parameters", tags = INGREDIENT_TAG)
    public Ingredient createRecipe(@RequestBody IngredientRequest ingredientRequest) {
        return ingredientService.save(mapper.map(ingredientRequest, Ingredient.class));
    }
}
