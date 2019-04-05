package com.sz.rpg.utils;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public final class JSONDeserializerUtil {

    private final static Logger LOGGER = Logger.getLogger(JSONDeserializerUtil.class);

    private JSONDeserializerUtil() {
    }

    public static <T> T  deserialize(InputStream inputStream, Class<T> clazz) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(inputStream, clazz);
        } catch (IOException e) {
            LOGGER.error("Cannot deserialize inputStream", e);
            return null;
        }

    }

    public static <K, V> Map<K,V> deserializeMap (InputStream inputStream, Class<K> keyClazz, Class<V> valueClazz){
        ObjectMapper objectMapper = new ObjectMapper();
        JavaType type = objectMapper.getTypeFactory().constructMapType(Map.class, keyClazz, valueClazz);
        try {
            return objectMapper.readValue(inputStream, type);
        } catch (IOException e) {
            LOGGER.error("Cannot deserialize inputStream", e);
            return null;
        }
    }
}
