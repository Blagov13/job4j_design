package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;
import java.util.ArrayList;

public class Trash extends AbstractStore {
    @Override
    public boolean supports(Food product) {
        return product.getExpiryDate().isBefore(LocalDate.now());
    }

    @Override
    public void clearProducts() {
        products = new ArrayList<>();
    }
}