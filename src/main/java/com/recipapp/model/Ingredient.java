package com.recipapp.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Ingredient {

    @Id
    private Long id;
    private String name;

}
