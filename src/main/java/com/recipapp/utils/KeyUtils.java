package com.recipapp.utils;

import com.google.common.hash.Hashing;

import com.recipapp.mapper.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.nio.charset.Charset;

public class KeyUtils {

    public static String generateMappingKey(ObjectMapper objectMapper) {
        // TODO implement better ids for mappers, maybe output is not enough
        String generatedKey = ((ParameterizedType) objectMapper.getClass()
            .getGenericSuperclass()).getActualTypeArguments()[1].getTypeName();
        return Hashing.md5().hashString(generatedKey, Charset.defaultCharset()).toString();
    }

    public static String generateMappingKey(Class clazz) {
        return Hashing.md5().hashString(clazz.getName(), Charset.defaultCharset()).toString();
    }

}
