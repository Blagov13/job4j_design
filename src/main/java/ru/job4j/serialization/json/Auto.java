package ru.job4j.serialization.json;

import java.util.Arrays;

public class Auto {
    private final boolean sale;
    private final int dateOfManufacture;
    private final Number number;
    private final String[] color;

    public Auto(boolean sale, int dateOfManufacture, Number number, String[] color) {
        this.sale = sale;
        this.dateOfManufacture = dateOfManufacture;
        this.number = number;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Auto{"
                + "sale=" + sale
                + ", dateOfManufacture=" + dateOfManufacture
                + ", number=" + number
                + ", color=" + Arrays.toString(color)
                + '}';
    }
}

