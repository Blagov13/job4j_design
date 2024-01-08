package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        String[] filters = argsName.get("filter").split(",");
        List<Integer> csv = new ArrayList<>();
        try (FileInputStream fileInputStream = new FileInputStream(argsName.get("path"));
             Scanner scanner = new Scanner(fileInputStream);
             PrintWriter writer = new PrintWriter(new FileWriter(argsName.get("out")))) {
            if (scanner.hasNextLine()) {
                String firstLine = scanner.nextLine();
                List<String> cells = List.of(firstLine.split(argsName.get("delimiter")));
                for (String filter : filters) {
                    int i = cells.indexOf(filter);
                    if (i != -1) {
                        csv.add(i);
                    }
                }
                if ("stdout".equals(argsName.get("out"))) {
                    System.out.println(String.join(argsName.get("delimiter"), filters));
                } else {
                    writer.println(String.join(argsName.get("delimiter"), filters));
                }
            }
            while (scanner.hasNextLine()) {
                String field = scanner.nextLine();
                List<String> rsl = List.of(field.split(argsName.get("delimiter")));
                List<String> rslLine = new ArrayList<>();
                for (Integer i : csv) {
                    rslLine.add(rsl.get(i));
                }
                if ("stdout".equals(argsName.get("out"))) {
                    System.out.println(String.join(argsName.get("delimiter"), rslLine));
                } else {
                    writer.println(String.join(argsName.get("delimiter"), rslLine));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void validation(String[] args, ArgsName allArgs) {
        if (args.length != 4) {
            throw new IllegalArgumentException();
        }
        File directory = new File(allArgs.get("path"));
        if (!directory.exists() && !directory.isDirectory()) {
            throw new IllegalArgumentException();
        }
        if (!(allArgs.get("delimiter").length() == 1) || !",".equals(allArgs.get("delimiter"))) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) throws Exception {

        ArgsName argsName = ArgsName.of(args);
        validation(args, argsName);
        handle(argsName);
    }
}
