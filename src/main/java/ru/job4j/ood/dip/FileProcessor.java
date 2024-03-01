package ru.job4j.ood.dip;

import java.io.File;

public class FileProcessor {
    private CSVParser csvParser = new CSVParser();

    public void processFile(File file) {
        csvParser.parse(file);
    }

    /*Прямая зависимость от класса библиотеки*/
}
