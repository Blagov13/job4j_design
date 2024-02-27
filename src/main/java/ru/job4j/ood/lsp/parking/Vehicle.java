package ru.job4j.ood.lsp.parking;

public class Vehicle {
    private String type;
    private int size;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Vehicle(String type, int size) {
        this.type = type;
        this.size = size;
    }

}
