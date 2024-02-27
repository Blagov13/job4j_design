package ru.job4j.ood.lsp.storage;

import java.util.List;

public class Warehouse extends AbstractStore {
    public Warehouse(List<Food> products) {
        super(products);
    }

    @Override
    public void addProduct(Food food) {
        products.add(food);
    }

    @Override
    public List<Food> getProducts() {
        return products;
    }
}
