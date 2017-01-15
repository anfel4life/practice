package com.company;

import java.io.IOException;
import java.util.ArrayList;


public class ArraySorter {

    public static void main(String[] args) {

        String stringFromFile = ArrayFromFileUtil.readText();

        if (!stringFromFile.isEmpty()) {

            System.out.println("Here's an array from \"inputArray.txt\":");
            System.out.println(stringFromFile);
            System.out.println("\nIf you want to sort this array, press <Enter> please...");
            try {
                System.in.read();
            } catch (IOException e) {
                System.out.println("Sorry, we got I/O Exception...");
                //e.printStackTrace();
            }

            ArrayList<Integer> arraylist = ArrayFromFileUtil.strToArray(stringFromFile);
            String sortedArrayString = new SortArrayUtil().sortArray(arraylist);

            if (sortedArrayString != null && !sortedArrayString.isEmpty()) {
                System.out.println("Sorted array: ");
                System.out.println(sortedArrayString);
                System.out.println();
                System.out.println(new WriteInFileUtil().writeStrInFile(sortedArrayString));
            } else {
                System.out.println("There isn't values in array to be sorted");
            }
        } else {
            System.out.println("There isn't values in array to be sorted");
        }
    }
}
