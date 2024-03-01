package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class Warehouse extends AbstractStore {
    @Override
    public boolean supports(Food product) {
        LocalDate currentDate = LocalDate.now();
        long shelfLife = ChronoUnit.DAYS.between(product.getCreateDate(), product.getExpiryDate());
        long expiredPeriod = ChronoUnit.DAYS.between(product.getExpiryDate(), currentDate);
        return expiredPeriod < 0.25 * shelfLife;
    }

    @Override
    public void clearProducts() {
        products = new ArrayList<>();
    }
}
