package com.anilhorasan;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.JSONObject;

public class JsonParser {
    
    // Parse JSON string to Java object using Jackson
    public static <T> T parseWithJackson(String jsonString, Class<T> clazz) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, clazz);
    }

    // Parse JSON string to Java object using Gson
    public static <T> T parseWithGson(String jsonString, Class<T> clazz) {
        Gson gson = new Gson();
        return gson.fromJson(jsonString, clazz);
    }

    // Parse JSON string using org.json
    public static JSONObject parseWithOrgJson(String jsonString) {
        return new JSONObject(jsonString);
    }
}
