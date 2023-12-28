package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Map<FileProperty, Set<Path>> fileDuplicate = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        fileDuplicate.putIfAbsent(fileProperty, new HashSet<>());
        fileDuplicate.get(fileProperty).add(file);
        return FileVisitResult.CONTINUE;
    }

    public Map<FileProperty, Set<Path>> duplicate() {
        return fileDuplicate;
    }
}
