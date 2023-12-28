package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Set<FileProperty> duplicates = new HashSet<>();
    private final List<FileProperty> listDuplicates = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file,
                                     BasicFileAttributes attributes) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!duplicates.add(fileProperty)) {
            listDuplicates.add(fileProperty);
        }
        return super.visitFile(file, attributes);
    }

    public void outDuplicates() {
        listDuplicates.forEach(duplicate -> System.out.printf(duplicate.getName()));
    }
}
