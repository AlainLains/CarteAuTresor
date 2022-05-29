package utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public abstract class ReadFile {
    public static List<String> getFile(String filePath) throws Exception {

        List<String> rows = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Path.of(filePath))) {
            stream.forEach(rows::add);
        } catch (Exception e) {
            throw new FileNotFoundException("Fichier introuvable.");
        }

        return rows;
    }
}
