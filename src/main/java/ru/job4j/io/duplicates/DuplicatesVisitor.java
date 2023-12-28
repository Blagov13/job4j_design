package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Set<Path> duplicates = new HashSet<>();
    private final Map<FileProperty, Path> fileDuplicate = new HashMap<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (fileDuplicate.containsKey(fileProperty)) {
            duplicates.add(file);
            duplicates.add(fileDuplicate.get(fileProperty));
        } else {
            fileDuplicate.put(fileProperty, file);
        }
        return super.visitFile(file, attributes);
    }

    public void outDuplicates() {
        duplicates.forEach(System.out::println);
    }
}
