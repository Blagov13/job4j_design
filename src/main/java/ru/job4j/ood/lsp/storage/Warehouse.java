package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;

public class Warehouse extends AbstractStore {
    @Override
    public void addProduct(Food product) {
        if (product.getExpiryDate().isAfter(LocalDate.now().plusDays(10))) {
            super.addProduct(product);
        } else {
            System.out.println("Продукт " + product.getName() + " имеет малый срок годности");
            System.out.println("Невозможно принять на склад");
        }
    }
}
