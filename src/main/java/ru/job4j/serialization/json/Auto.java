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

    public boolean isSale() {
        return sale;
    }

    public void setSale(boolean sale) {
        this.sale = sale;
    }

    public int getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(int dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public Number getNumber() {
        return number;
    }

    public void setNumber(Number number) {
        this.number = number;
    }

    public String[] getColor() {
        return color;
    }

    public void setColor(String[] color) {
        this.color = color;
    }

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

