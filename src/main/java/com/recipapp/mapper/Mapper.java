package com.recipapp.mapper;

import com.google.common.collect.Maps;

import com.recipapp.error.MappingException;
import com.recipapp.utils.KeyUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class Mapper {

    private Map<String, ObjectMapper> availableMappers;
    private static final Logger LOG = LoggerFactory.getLogger(Mapper.class);

    public <O extends Object> O map(Object input, Class<O> output) {
        ObjectMapper<Object, O> objectMapper = availableMappers
            .get(KeyUtils.generateMappingKey(input.getClass(), output));
        if (objectMapper == null) {
            LOG.error("Could not find objectMapper for" + output.getName());
            throw new MappingException("ObjectMapper for given input does not exist");
        }
        return objectMapper.map(input, output);
    }

    @Autowired
    public void populateMappers(List<ObjectMapper> objectMappers) {
        availableMappers = Maps.newHashMap();
        for (ObjectMapper objectMapper : objectMappers) {
            availableMappers.put(objectMapper.getKey(), objectMapper);
        }
    }

}
