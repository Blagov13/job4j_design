package ru.job4j.fileSearch;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validation {
    private ArgsFile args;
    private Path root;
    private String nameFile;
    private String outputFile;
    private String typeSearch;
    private int size;

    public Path getRoot() {
        return root;
    }

    public String getNameFile() {
        return nameFile;
    }

    public String getOutputFile() {
        return outputFile;
    }

    public String getTypeSearch() {
        return typeSearch;
    }

    public Validation(String[] args) {
        this.args = ArgsFile.of(args);
        this.size = args.length;
    }

    public boolean Valid() {
        try {
            examinationSize();
            examinationDirectory();
            examinationTypeSearch();
            out();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(
                    "Format:java -jar find.jar -d=/Users/aleksandrblagov/job4j_design -n=*.?xt -t=mask -o=log.txt");
        }
        return true;
    }

    private boolean examinationSize() {
        return size == 4;
    }

    private boolean examinationDirectory() {
        boolean rsl = false;
        File temp = new File(args.get("d"));
        if (temp.isDirectory()) {
            root = Paths.get(temp.getPath());
            rsl = true;
        }
        return rsl;
    }

    private boolean examinationFileName() {
        boolean rsl = false;
        if (!args.get("n").isEmpty()) {
            nameFile = args.get("n");
            rsl = true;
        }
        return rsl;
    }

    private boolean examinationTypeSearch() {
        boolean rsl = false;
        typeSearch = args.get("t");
        if (typeSearch.equals("mask")) {
            rsl = examinationFileMask();
        } else if (typeSearch.equals("name")) {
            rsl = examinationFileName();
        }
        return rsl;
    }

    private boolean examinationFileMask() {
        boolean rsl = false;
        if (args.get("n").equals("*.?")) {
            nameFile = args.get("n");
            rsl = true;
        }
        return rsl;
    }

    private boolean out() {
        boolean rsl = false;
        if (args.get("o").contains(".")) {
            outputFile = args.get("o");
            rsl = true;
        }
        return rsl;
    }
}
