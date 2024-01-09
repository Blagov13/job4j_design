package ru.job4j.serialization.json;

public class Number {
    private final String serialNumber;

    public Number(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Number{" +
                "serialNumber='" + serialNumber + '\'' +
                '}';
    }
}
