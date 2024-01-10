package ru.job4j.fileSearch;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFile implements FileVisitor<Path> {
    private String fileSearch;
    private Path path;
    private String type;
    private final List<Path> list;

    public SearchFile(Path path, String type, String fileSearch) {
        this.fileSearch = fileSearch;
        this.path = path;
        this.type = type;
        this.list = new ArrayList<>();
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        if (type.equals("mask") && file.toFile().getName().matches(fileSearch
                .replace(".", "[.]")
                .replace("*", ".+")
                .replace("?", "."))) {
            list.add(file);
        } else if (type.equals("mask") && file.toFile().getName().equals(fileSearch)) {
            list.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
        return FileVisitResult.CONTINUE;
    }

    public void of() throws IOException {
        Files.walkFileTree(path, this);
    }

    public List<Path> getPaths() {
        return list;
    }
}
