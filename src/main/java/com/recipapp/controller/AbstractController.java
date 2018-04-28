package com.recipapp.controller;

import static com.recipapp.controller.ControllerTags.RECIPE_TAG;

import com.recipapp.controller.request.RecipeRequest;
import com.recipapp.mapper.Mapper;
import com.recipapp.model.AbstractDocument;
import com.recipapp.service.AbstractDocumentService;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public abstract class AbstractController<O extends AbstractDocument> {

    @Autowired
    protected Mapper mapper;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ApiOperation(value = "Creates a new document with the given parameters")
    public O create(@RequestBody RecipeRequest recipeRequest) {
        return this.getService().save(mapper.map(recipeRequest, getDocumentClass()));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Gets the document for the given id")
    public O getRecipeById(@PathVariable Long id) {
        return this.getService().get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Deletes the document for the given id")
    public O deleteRecipe(@PathVariable Long id) {
        return this.getService().delete(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Updates the document for the given id")
    public O update(@PathVariable Long id, @RequestBody RecipeRequest recipeRequest) {
        return this.getService().update(mapper.map(recipeRequest, getDocumentClass()), id);
    }

    public abstract AbstractDocumentService<O> getService();

    public abstract Class<O> getDocumentClass();
}
