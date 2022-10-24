package com.depp3.horasextras.generals.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Jsons {

    public static String convertObjectToJson(Object obj) {
        String object;
        try {
            object = new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return object;
    }
}
