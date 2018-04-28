package com.recipapp.controller;

import static com.recipapp.controller.ControllerTags.INGREDIENT_TAG;

import com.recipapp.model.Ingredient;
import com.recipapp.service.AbstractDocumentService;
import com.recipapp.service.IngredientService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredients")
@Api(tags = INGREDIENT_TAG)
public class IngredientController extends AbstractController<Ingredient> {

    @Autowired
    private IngredientService ingredientService;

    @Override
    public AbstractDocumentService<Ingredient> getService() {
        return ingredientService;
    }

    @Override
    public Class<Ingredient> getDocumentClass() {
        return Ingredient.class;
    }
}
