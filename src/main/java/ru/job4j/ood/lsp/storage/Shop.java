package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Shop extends AbstractStore {
    @Override
    public boolean supports(Food product) {
        LocalDate currentDate = LocalDate.now();
        long daysToExpire = ChronoUnit.DAYS.between(currentDate, product.getExpiryDate());
        long shelfLife = ChronoUnit.DAYS.between(product.getCreateDate(), product.getExpiryDate());

        if (daysToExpire >= 0.25 * shelfLife && daysToExpire <= 0.75 * shelfLife) {
            return true;
        }

        if (daysToExpire > 0.75 * shelfLife) {
            double newPrice = product.getPrice() * (1 - product.getDiscount() * 0.2);
            product.setPrice(newPrice);
            return true;
        }

        return false;
    }

    @Override
    public void clearProducts() {
        products = new ArrayList<>();
    }
}