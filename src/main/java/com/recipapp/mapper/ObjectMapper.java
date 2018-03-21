package com.recipapp.mapper;

public interface ObjectMapper<I, O> {

    O map(I input, Class<O> clazz);

    String getKey();
}
