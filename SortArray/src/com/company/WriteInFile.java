package com.company;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class WriteInFile {
    private static String OUTPUT_FILE_NAME = "outputArray.txt";

    String writeStrInFile(String text) {
        String result;
        String filePath = "";

        try {
            filePath = URLDecoder.decode(getClass().getResource("/").getPath(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        File file = new File(filePath + OUTPUT_FILE_NAME);

        try {
            if (!file.exists()) {
                file.delete();
            } else {
                file.createNewFile();
            }

            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.print(text);
                result = "Data have been written successfully in file: \n";
            }
        } catch (IOException e) {
            result = "Sorry, we got I/O Exception when tried to write data in file: \n";
            // throw new RuntimeException(e);
        }
        return result + file.getAbsolutePath();
    }
}
