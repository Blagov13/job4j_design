package ru.job4j.ood.lsp.storage;

import java.util.List;

public class ControlQuality {
    private final List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void redistribute(Food product) {
        for (Store store : stores) {
            if (store.supports(product)) {
                store.addProduct(product);
                return;
            }
        }
        throw new IllegalStateException("No store supports the product: " + product.getName());
    }
}
