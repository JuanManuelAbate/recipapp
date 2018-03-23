package com.recipapp.mapper;

import com.recipapp.utils.KeyUtils;

public abstract class AbstractObjectMapper<I, O> implements ObjectMapper<I, O> {

    private String key;

    public AbstractObjectMapper() {
        key = KeyUtils.generateMappingKey(this);
    }

    public String getKey() {
        return key;
    }
}
