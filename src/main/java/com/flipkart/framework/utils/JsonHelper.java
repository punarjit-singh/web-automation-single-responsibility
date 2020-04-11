package com.flipkart.framework.utils;

import com.google.gson.*;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;

public class JsonHelper {

    /**
     * Reads a .json file and return the values in a Map
     * @param path
     * @return Map<?, ?>
     */
    public Map<?, ?> readJson(String path) {
        Map<?, ?> jsonMap = null;
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get(path));
            jsonMap = gson.fromJson(reader, Map.class);
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jsonMap;
    }

}
