package utils;

import java.io.File;
import java.io.IOException;

public class WriteFile {
    public static void writeResult() {
        try {
            File result = new File("result.txt");

            if (result.createNewFile()) {
                System.out.println("File created: " + result.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
