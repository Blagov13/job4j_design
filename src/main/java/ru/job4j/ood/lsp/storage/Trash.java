package ru.job4j.ood.lsp.storage;

import java.time.LocalDate;

public class Trash extends AbstractStore {
    @Override
    public boolean supports(Food product) {
        return product.getExpiryDate().isBefore(LocalDate.now());
    }
}