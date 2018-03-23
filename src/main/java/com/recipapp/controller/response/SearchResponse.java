package com.recipapp.controller.response;

import com.recipapp.model.Recipe;
import lombok.Data;

import java.util.List;

@Data
public class SearchResponse<O> {

    private List<O> data;
    private int pages;
    private int size;
}
