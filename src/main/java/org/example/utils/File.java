package org.example.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class File {
    public void saveToFile(String text, String filename) {
        String path = "src/main/java/org/example/assets/temp/";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(path + filename, true));

            writer.write(text);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo");
        }
    }
}
