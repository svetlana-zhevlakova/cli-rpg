package com.sz.rpg.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sz.rpg.domain.gameplay.Game;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;

public final class JSONDeserializerUtil {

    private final static Logger LOGGER = Logger.getLogger(JSONDeserializerUtil.class);

    private JSONDeserializerUtil() {
    }

    public static Game deserialize(InputStream payload) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(payload, Game.class);
        } catch (IOException e) {
            LOGGER.error("Cannot deserialize payload", e);
            return null;
        }

    }
}
