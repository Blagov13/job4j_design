package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void redistribute() {
        List<Food> allProducts = new ArrayList<>();
        stores.forEach(store -> allProducts.addAll(store.getProducts()));

        for (Food product : allProducts) {
            double shelfLifePercentage = calculateShelfLifePercentage(product);
            Store destination;

            if (shelfLifePercentage < 25) {
                destination = getWarehouse();
            } else if (shelfLifePercentage >= 25 && shelfLifePercentage < 75) {
                destination = getShop();
            } else if (shelfLifePercentage >= 75 && shelfLifePercentage < 100) {
                destination = getShop();
                product.setPrice(product.getPrice() * (1 - product.getDiscount()));
            } else {
                destination = getTrash();
            }

            destination.addProduct(product);
        }
    }

    private double calculateShelfLifePercentage(Food product) {
        long totalDays = product.getExpiryDate().toEpochDay() - product.getCreateDate().toEpochDay();
        long remainingDays = product.getExpiryDate().toEpochDay() - LocalDate.now().toEpochDay();
        return (double) remainingDays / totalDays * 100;
    }

    private Store getWarehouse() {
        return stores.get(0);
    }

    private Store getShop() {
        return stores.get(1);
    }

    private Store getTrash() {
        return stores.get(2);
    }
}
