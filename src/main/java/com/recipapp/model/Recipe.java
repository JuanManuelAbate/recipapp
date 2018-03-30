package com.recipapp.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
public class Recipe extends AbstractDocument {

    private String name;
    private String description;
    private List<Picture> photos;
    private List<IngredientQuantity> ingredients;
    private List<Step> steps;
}
