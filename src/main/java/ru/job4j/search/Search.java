package ru.job4j.search;

import ru.job4j.io.ArgsName;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    private static void validate(ArgsName argsName) {
        File file = new File(argsName.get("d"));
        if (!file.isDirectory()) {
            throw new IllegalArgumentException();
        }
        if (!(argsName.get("t").matches("mask")
                || argsName.get("t").matches("name") || argsName.get("t").matches("regex"))) {
            throw new IllegalArgumentException();
        }
        if (!argsName.get("o").matches(".*\\..*")) {
            throw new IllegalArgumentException();
        }
        if ("mask".equals(argsName.get("t")) && (!argsName.get("n").startsWith("*"))) {
            throw new IllegalArgumentException();
        }
        if ("name".equals(argsName.get("t")) && (!argsName.get("n").matches(".*\\..*"))) {
            throw new IllegalArgumentException();
        }
        if ("regex".equals(argsName.get("t")) && (!argsName.get("n").startsWith(".*"))) {
            throw new IllegalArgumentException();
        }
    }

    private static Predicate<Path> predicate(ArgsName argsName) {
        Predicate<Path> predicate;
        if ("name".equals(argsName.get("t"))) {
            predicate = path -> path.toFile().getName().equals(argsName.get("n"));
        } else if ("mask".equals(argsName.get("t"))) {
            String regex = argsName.get("n").replace("*", "\\w+").replace("?", "\\w");
            predicate = path -> path.toFile().getName().matches(regex);
        } else {
            predicate = path -> path.toFile().getName().matches(argsName.get("n"));
        }
        return predicate;
    }

    private static void write(ArgsName argsName) throws IOException {
        Predicate<Path> condition = predicate(argsName);
        SearchFile searchFile = new SearchFile(condition);
        Files.walkFileTree(Paths.get(argsName.get("d")), searchFile);
        List<Path> list = searchFile.getPaths();
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            for (Path path : list) {
                bufferedWriter.write(path.toAbsolutePath().normalize().toString());
                bufferedWriter.newLine();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argsName = ArgsName.of(args);
        validate(argsName);
        write(argsName);
    }
}
