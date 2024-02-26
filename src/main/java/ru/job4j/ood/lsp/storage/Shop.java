package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;

public class Shop extends AbstractStore {
    @Override
    public void addProduct(Food product) {
        if (product.getExpiryDate().isAfter(LocalDate.now().plusDays(10))) {
            super.addProduct(product);
        } else {
            product.setPrice(product.getPrice() * (1 - product.getDiscount()));
            super.addProduct(product);
            System.out.println("Цена продукта " + product.getName() + " снижена, из за приблежения срока годности");
        }
    }
}
