package com.company;


import java.util.HashMap;

class StringHolderSingl {
    private static HashMap<String, String> HASHED_RESULTS_MAP;

    private static StringHolderSingl instance;

    private StringHolderSingl() {
        HASHED_RESULTS_MAP = new HashMap<String, String>();
    }

    static StringHolderSingl getInstance() {
        if (instance == null)
            instance = new StringHolderSingl();
        return instance;
    }

    void addString(String str, String message) {
        HASHED_RESULTS_MAP.put(str, message);
    }

    String getUniqueCharsForString(String str) {
        if (HASHED_RESULTS_MAP != null && !HASHED_RESULTS_MAP.isEmpty()) {
            return HASHED_RESULTS_MAP.containsKey(str) ? HASHED_RESULTS_MAP.get(str) : null;
        }
        return null;
    }
}
