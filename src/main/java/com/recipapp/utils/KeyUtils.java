package com.recipapp.utils;

import com.google.common.hash.Hashing;

import com.recipapp.mapper.ObjectMapper;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

public class KeyUtils {

    public static String generateMappingKey(ObjectMapper objectMapper) {
        // TODO implement better ids for mappers, maybe output is not enough
        Type[] actualTypeArguments = ((ParameterizedType) objectMapper.getClass()
            .getGenericSuperclass()).getActualTypeArguments();
        String output = actualTypeArguments[1].getTypeName();
        String input = actualTypeArguments[0].getTypeName();
        return Hashing.md5().hashString(input + output, Charset.defaultCharset()).toString();
    }

    public static String generateMappingKey(Class inClazz, Class ouClazz) {
        return Hashing.md5().hashString(inClazz.getName() + ouClazz.getName(),
            Charset.defaultCharset()).toString();
    }

}
