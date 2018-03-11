package com.recipapp.model;

import lombok.Data;

import java.util.List;

@Data
public class Recipe {

    private Long id;
    private String description;
    private List<Picture> photos;
    private List<Ingredient> ingredients;
    private List<Step> steps;

}
