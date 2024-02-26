package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    private int daysToExpirationPercentage(LocalDate createDate, LocalDate expiryDate, LocalDate now) {
        long totalDays = createDate.until(expiryDate, ChronoUnit.DAYS);
        long remainingDays = now.until(expiryDate, ChronoUnit.DAYS);

        return (int) ((double) remainingDays / totalDays * 100);
    }

    public void resort() {
        for (Store store : stores) {
            List<Food> products = store.getProducts();
            for (Food product : products) {
                int percentage = daysToExpirationPercentage(product.getCreateDate(), product.getExpiryDate(), LocalDate.now());
                if (percentage < 25) {
                    distributeToStore(new Warehouse(), product);
                } else if (percentage >= 25 && percentage < 75) {
                    distributeToStore(new Shop(), product);
                } else if (percentage >= 75) {
                    product.setPrice(product.getPrice() * (1 - product.getDiscount()));
                    distributeToStore(new Shop(), product);
                } else {
                    distributeToStore(new Trash(), product);
                }
            }
        }
    }

    private void distributeToStore(Store store, Food product) {
        store.addProduct(product);
    }
}
