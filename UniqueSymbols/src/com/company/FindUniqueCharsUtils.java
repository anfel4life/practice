package com.company;


import java.util.ArrayList;
import java.util.Arrays;

abstract class FindUniqueCharsUtils {
    private static ArrayList<Character> getUniqueCharsList(String str) {
        ArrayList<Character> uniqueCharsList = new ArrayList<Character>();

        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        // System.out.println(charArr);
        if (charArr.length == 1) {
            uniqueCharsList.add(charArr[0]);
        } else {
            for (int i = 0; i < charArr.length; i++) {
                boolean isUniqueChar;
                //compare char[i] with the next elem of sorted array if it isn't the last elem in array
                isUniqueChar = i > charArr.length - 2;
                isUniqueChar = isUniqueChar || (charArr[i] != charArr[i + 1]);

                if (isUniqueChar) {
                    //compare char[i] with the next elem of sorted array if it isn't the first elem in array
                    isUniqueChar = i == 0 || (charArr[i] != charArr[i - 1]);
                    if (isUniqueChar) {
                        uniqueCharsList.add(charArr[i]);
                    }
                }
            }
        }
        return uniqueCharsList;
    }

    static String getResultMessage(String str) {
        String resultMessage = StringHolderSingl.getInstance().getUniqueCharsForString(str);
        if (resultMessage == null) {          
            StringBuilder resultStr = new StringBuilder();
            StringBuilder chars = new StringBuilder();
            ArrayList<Character> uniqueCharList = getUniqueCharsList(str);

            int i = 0;
            if (uniqueCharList != null && !uniqueCharList.isEmpty()) {
                int lastElem = uniqueCharList.size() - 1;
                for (char ch : uniqueCharList) {
                    chars.append("\'").append(ch).append("\'");
                    if (i < lastElem) {
                        chars.append(", ");
                    }
                    i++;
                }
            }

            if (i == 0) {
                resultStr.append("There aren't any unique characters in the input string.");
            } else if (i == 1) {
                resultStr.append("There is ");
                resultStr.append(i);
                resultStr.append(" unique character in the input string:\n");
            } else {
                resultStr.append("There are ");
                resultStr.append(i);
                resultStr.append(" unique characters in the input string:\n");
            }

            resultMessage = resultStr.append(chars).toString();
            StringHolderSingl.getInstance().addString(str, resultMessage);
        } else {
             System.out.println(">This string has been already counted.");
        }

        return resultMessage;
    }
}
