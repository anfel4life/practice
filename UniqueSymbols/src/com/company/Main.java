package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        BufferedReader br = null;
        boolean isContinue = true;


        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (isContinue) {

                System.out.print("Enter string and press <Enter> to get the number of unique characters " +
                        "\nor enter \"q\" and press <Enter> to exit: ");
                System.out.println();

                String input = br.readLine();

                if ("q".equals(input)) {
                    isContinue = false;
                } else if ("".equals(input)){
                    System.out.println(">You didn't pased any characters");
                    System.out.println("-----------");
                } else {
                    long start = System.currentTimeMillis();

                    System.out.println(">" + FindUniqueCharsUtils.getResultMessage(input));
                    //System.out.println("input string: " + input);
                    long finish = System.currentTimeMillis();
                    long timeConsumedMillis = finish - start;
                    System.out.println("time: " + timeConsumedMillis);
                    System.out.println("-----------\n");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Exit!");
        System.exit(0);
    }
}
