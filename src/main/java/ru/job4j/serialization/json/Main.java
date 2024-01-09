package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        final Auto auto = new Auto(true, 2004, new Number("123-321"),
                new String[]{"Ford", "blue"});
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(auto));
        final String autoJson =
                "{"
                        + "\"sale\":true,"
                        + "\"dateOfManufacture\":2004,"
                        + "\"number\":"
                        + "{"
                        + "\"serialNumber\":\"123-321\""
                        + "},"
                        + "\"color\":"
                        + "[\"BMW\",\"Black\"]"
                        + "}";
        final Auto autoMod = gson.fromJson(autoJson, Auto.class);
        System.out.println(autoMod);
    }
}
