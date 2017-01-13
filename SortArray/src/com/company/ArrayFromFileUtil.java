package com.company;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Scanner;


abstract class ArrayFromFileUtil {
    private static String INPUT_FILE_NAME = "inputArray.txt";

    static String readText() {
        StringBuilder s = new StringBuilder();
        String filePath = "";
        try {
            filePath = URLDecoder.decode(new File(".").getCanonicalPath() + File.separator + "resources"
                    + File.separator + INPUT_FILE_NAME, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        File myFile = new File(filePath);
        if (myFile.exists() && myFile.isFile()) {

            Scanner in = null;
            try {
                in = new Scanner(myFile);
                while (in.hasNext()) {
                    s.append(in.nextLine());
                }
            } catch (IOException ex) {
                System.out.println("We have troubles with inputArray.txt: " + ex.getMessage());
            } finally {
                if (in != null) {
                    in.close();
                }
            }
        }
        return s.toString();
    }

    static ArrayList<Integer> strToArray(String txt) {
        ArrayList<Integer> resultList = new ArrayList<Integer>();
        String[] strArray;

        if (txt != null && !txt.isEmpty()) {
            strArray = txt.split(",");

            for (String aStrArray : strArray) {
                String strValue = aStrArray.trim();
                if (!strValue.isEmpty()) {
                    try {
                        resultList.add(Integer.parseInt(strValue));
                    } catch (NumberFormatException e) {
                        System.out.println("\"" + aStrArray + "\"isn't correct value.");
                        //e.printStackTrace();
                    }
                }
            }
        }
        return resultList;
    }
}
