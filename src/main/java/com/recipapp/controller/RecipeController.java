package com.recipapp.controller;

import com.recipapp.model.Recipe;
import com.recipapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeController {

    @Autowired
    private RecipeRepository repository;

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public Recipe createRecipe(@RequestBody Recipe recipe){
       return repository.save(recipe);
    }

}
