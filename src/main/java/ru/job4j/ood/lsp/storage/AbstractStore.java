package ru.job4j.ood.lsp.storage;

import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> products;

    public AbstractStore(List<Food> products) {
        this.products = products;
    }
}
