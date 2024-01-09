package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "number")
public class Number {
    private String serialNumber;

    public Number(){}

    public Number(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    @Override
    public String toString() {
        return "Number{"
                + "serialNumber='" + serialNumber + '\''
                + '}';
    }
}
