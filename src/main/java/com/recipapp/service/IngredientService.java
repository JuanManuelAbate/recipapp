package com.recipapp.service;

import com.recipapp.model.Ingredient;
import com.recipapp.model.SequenceIdentifier;
import com.recipapp.repository.DocumentRepository;
import com.recipapp.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class IngredientService extends AbstractDocumentService<Ingredient> {

    @Autowired
    IngredientRepository ingredientRepository;

    @Override
    protected Ingredient preCreation(Ingredient document) {
        return document;
    }

    @Override
    protected SequenceIdentifier getSequenceId() {
        return SequenceIdentifier.INGREDIENT;
    }

    @Override
    protected DocumentRepository<Ingredient> getRecipeRepository() {
        return ingredientRepository;
    }
}
