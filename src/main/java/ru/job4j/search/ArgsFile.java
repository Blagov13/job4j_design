package ru.job4j.search;

import java.util.HashMap;
import java.util.Map;

public class ArgsFile {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String param : args) {
            String[] keyValue = param.split("=", 2);
            validate(keyValue);
            values.put(keyValue[0].substring(1), keyValue[1]);
        }
    }

    public static ArgsFile of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException();
        }
        ArgsFile names = new ArgsFile();
        names.parse(args);
        return names;
    }

    private static void validate(String[] args) {
        if (args.length < 2 || args[0].isEmpty() || args[1].isEmpty()) {
            throw new IllegalArgumentException();
        }
        if (!args[0].startsWith("-") || args[0].length() < 2) {
            throw new IllegalArgumentException();
        }
    }
}
