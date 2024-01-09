package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

@XmlRootElement(name = "auto")
@XmlAccessorType(XmlAccessType.FIELD)
public class Auto {
    @XmlAttribute
    private boolean sale;
    @XmlAttribute
    private int dateOfManufacture;
    private Number number;
    private String[] color;

    public Auto() {
    }

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

