package com.company;


import java.util.HashMap;

abstract class ResutsHolderUtils {
    private static HashMap<String, String> stringsMap = new HashMap<String, String>();

    static void addString (String str, String message) {
        stringsMap.put(str, message);
    }

    static String getUniqueCharsForString(String str){
        if (stringsMap != null && !stringsMap.isEmpty()) {
            return stringsMap.containsKey(str) ? stringsMap.get(str) : null;
        }
        return null;
    }
}
