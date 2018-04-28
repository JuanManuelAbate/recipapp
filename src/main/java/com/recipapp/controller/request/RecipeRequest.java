package com.recipapp.controller.request;

import com.recipapp.model.Picture;
import com.recipapp.model.Step;

import lombok.Data;

import java.util.List;

@Data
public class RecipeRequest {

    private String name;
    private String description;
    private List<Picture> photos;
    private List<IngredientQuantityRequest> ingredients;
    private List<Step> steps;
}
