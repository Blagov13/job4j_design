package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("/Users/aleksandrblagov/job4j_design"), duplicatesVisitor);
        Map<FileProperty, Set<Path>> rsl = duplicatesVisitor.duplicate();
        for (FileProperty fileKey : rsl.keySet()) {
            if (rsl.get(fileKey).size() > 1) {
                for (Path fileKeySet : rsl.get(fileKey)) {
                    System.out.println(fileKeySet);
                }
            }
        }
    }
}
