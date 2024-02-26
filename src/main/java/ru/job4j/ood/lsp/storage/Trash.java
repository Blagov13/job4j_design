package ru.job4j.ood.lsp.storage;

public class Trash extends AbstractStore {
    @Override
    public void addProduct(Food product) {
        super.addProduct(product);
        System.out.println("Продукт " + product.getName() + " испорчен.");
    }
}
