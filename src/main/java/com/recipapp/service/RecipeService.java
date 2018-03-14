package com.recipapp.service;

import com.recipapp.model.Recipe;
import com.recipapp.model.SequenceIdentifier;
import com.recipapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class RecipeService extends AbstractDocumentService<Recipe, Long> {

    @Autowired
    private RecipeRepository recipeRepository;

    @Override
    protected Recipe preCreation(Recipe document) {
        // i'm not doing anything here
        return document;
    }

    @Override
    protected SequenceIdentifier getSequenceId() {
        return SequenceIdentifier.RECIPE;
    }

    @Override
    protected MongoRepository<Recipe, Long> getRecipeRepository() {
        return recipeRepository;
    }
}
