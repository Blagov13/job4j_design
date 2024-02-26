package ru.job4j.ood.lsp.parking;
/*Транспортное средство*/
public class Vehicle {

    /*Легковая или грузовая*/
    private String type;
    /*Размер транспортного средства*/
    private int size;

    public Vehicle(String type, int size) {
        this.type = type;
        this.size = size;
    }

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
}
