package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    protected List<Food> products = new ArrayList<>();

    @Override
    public void addProduct(Food product) {
        products.add(product);
    }

    public abstract boolean supports(Food product);

    @Override
    public List<Food> getProducts() {
        return products;
    }
}
