package com.recipapp.service;

import com.recipapp.controller.request.RecipeSearchRequest;
import com.recipapp.model.Recipe;
import com.recipapp.model.SequenceIdentifier;
import com.recipapp.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Recipe> searchRecipesByParams(RecipeSearchRequest request) {
        PageRequest pageRequest = PageRequest.of(request.getPage(), request.getSize());
        if (request.getName() == null) {
            return recipeRepository.findAll(pageRequest);
        }
        return recipeRepository
                .findByNameContaining(request.getName(), pageRequest);
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
