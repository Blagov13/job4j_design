package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            throw new IndexOutOfBoundsException();
        }
        validation(args[0], args[1]);
        Path start = Paths.get(args[0]);
        search(start, path -> path.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void validation(String initialFolder, String fileExtension) {
        Path path = Paths.get(initialFolder);
        if (!path.toFile().exists()) {
            throw new IllegalArgumentException(
                    String.format("Exist \"%s\"", path.toAbsolutePath())
            );
        }
        if (!path.toFile().isDirectory()) {
            throw new IllegalArgumentException(
                    String.format("Directory \"%s\"", path.toAbsolutePath())
            );
        }
        if (!fileExtension.startsWith(".")) {
            throw new IllegalArgumentException(
                    String.format("Directory \"%s\"", fileExtension)
            );
        }
    }
}