package ru.job4j.ood.lsp.parking;

public class Vehicle {
    static final String TYPE_CAR = "car";
    static final String TYPE_TRUCK = "truck";
    private String type;
    private int size;

    public Vehicle(String type, int size) {
        this.type = type;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public boolean isCar() {
        return size == 1;
    }

    public boolean isTruck() {
        return size > 1;
    }
}
