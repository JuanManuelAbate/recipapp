package com.recipapp.mapper;

import com.recipapp.error.MappingException;
import com.recipapp.utils.KeyUtils;

import org.slf4j.Logger;

public abstract class AbstractObjectMapper<I, O> implements ObjectMapper<I, O> {

    private String key;

    public AbstractObjectMapper() {
        key = KeyUtils.generateMappingKey(this);
    }

    public String getKey() {
        return key;
    }

    @Override
    public final O map(I input, Class<O> clazz) {
        O output = null;
        try {
            output = clazz.newInstance();
        } catch (Exception ex) {
            getLogger().error("Could not map recipe", ex);
            throw new MappingException("Could not map recipe", ex);
        }
        return this.doMap(input, output);
    }

    protected abstract O doMap(I input, O output);

    protected abstract Logger getLogger();
}
