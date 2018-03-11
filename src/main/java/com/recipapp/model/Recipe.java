package com.recipapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Recipe {

    @Id
    @JsonIgnore
    private Long id;
    private String description;
    private List<Picture> photos;
    private List<IngredientQuantity> ingredients;
    private List<Step> steps;

}
