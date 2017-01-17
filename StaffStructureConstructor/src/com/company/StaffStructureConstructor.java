package com.company;

import com.company.UserInterface.CommandParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StaffStructureConstructor {

    public static void main(String[] args) {
        BufferedReader br = null;
        boolean isContinue = true;

        System.out.print("Enter command and press <Enter> (\"h\" for help).");
        System.out.println();

        try {

            br = new BufferedReader(new InputStreamReader(System.in));

            while (isContinue) {

                System.out.print(">_ ");

                String input = br.readLine();

                if ("exit".equals(input)) {
                    isContinue = false;
                } else if ("".equals(input)) {
                    System.out.println("You didn't enter any commands");
                    System.out.println("-----------");
                } else {
                    System.out.println(new CommandParser().usersCommandProcessing(input));
                    System.out.println("-----------");
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
