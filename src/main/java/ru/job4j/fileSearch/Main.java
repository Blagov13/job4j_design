package ru.job4j.fileSearch;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Validation validation = new Validation(args);
        if (validation.Valid()) {
            SearchFile searchFile = new SearchFile(validation.getRoot(),
                    validation.getTypeSearch(), validation.getNameFile());
            searchFile.of();
            List<Path> out = searchFile.getPaths();
            try (PrintWriter printWriter = new PrintWriter(new BufferedOutputStream(
                    new FileOutputStream(validation.getOutputFile())))) {
                out.forEach(printWriter::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
