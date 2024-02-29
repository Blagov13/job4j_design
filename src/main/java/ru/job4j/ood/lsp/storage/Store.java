package ru.job4j.ood.lsp.storage;

import java.util.List;

public interface Store {
    void addProduct(Food product);

    boolean supports(Food product);

    List<Food> getProducts();
}
