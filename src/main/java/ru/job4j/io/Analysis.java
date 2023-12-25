package ru.job4j.io;

import java.io.*;

import static java.lang.System.lineSeparator;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean time = true;
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            while (read.ready()) {
                String line = read.readLine();
                if (time == (line.startsWith("400") || line.startsWith("500"))) {
                    time = !time;
                    out.append(line.substring(4)).append(";")
                            .append(time ? lineSeparator() : "");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}
