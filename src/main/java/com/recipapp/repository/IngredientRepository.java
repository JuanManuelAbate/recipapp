package com.recipapp.repository;

import com.recipapp.model.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends DocumentRepository<Ingredient> {
}
