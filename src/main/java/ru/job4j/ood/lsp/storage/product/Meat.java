package ru.job4j.ood.lsp.storage.product;

import ru.job4j.ood.lsp.storage.Food;

import java.time.LocalDate;

public class Meat extends Food {
    public Meat(String name, LocalDate expiryDate, LocalDate createDate, double price, double discount) {
        super(name, expiryDate, createDate, price, discount);
    }
}
