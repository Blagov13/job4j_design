package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Paths.get("/Users/aleksandrblagov/job4j_design"), duplicatesVisitor);
        duplicatesVisitor.outDuplicates();
    }
}
