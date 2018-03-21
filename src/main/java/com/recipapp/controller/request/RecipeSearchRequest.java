package com.recipapp.controller.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class RecipeSearchRequest {

    @Getter
    @Setter
    private String name;
    @NotNull
    @Max(30)
    @Getter
    @Setter
    private Integer size;
    @NotNull
    @Min(1)
    @Setter
    private Integer page;

    /**
     * This is maintaining the first page as 1, simpler for the ui.
     */
    public Integer getPage() {
        return page - 1;
    }

}
