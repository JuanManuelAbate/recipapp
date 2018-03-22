package com.recipapp.repository;

import com.recipapp.model.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends DocumentRepository<Recipe> {

    Page<Recipe> findByNameContainingAndDeletedIsFalse(String name, Pageable pageable);

}
