package ru.job4j.io;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    private final String file;

    public LogFilter(String file) {
        this.file = file;
    }

    public List<String> filter() {
        List<String> rsl = null;
        try (BufferedReader in = new BufferedReader(new FileReader(this.file))) {
            rsl = in.lines().filter(s -> s.contains(" 404 ")).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    public void saveTo(String out) {
        var data = filter();
        try (Writer printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(out)
                ))) {
            for (String o : data) {
                printWriter.write(o);
                printWriter.write(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter("data/log.txt");
        logFilter.filter().forEach(System.out::println);
        new LogFilter("data/log.txt").saveTo("data/log404.txt");
    }
}
