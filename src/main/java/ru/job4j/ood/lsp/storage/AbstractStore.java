package ru.job4j.ood.lsp.storage;

import java.util.ArrayList;
import java.util.List;

public class AbstractStore implements Store {
    protected List<Food> products;

    public AbstractStore() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Food product) {
        products.add(product);
    }
    public List<Food> getProducts() {
        return products;
    }
}
