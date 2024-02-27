package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ShopTest {
    @Test
    public void testAddProduct() {
        Shop shop = new Shop(new ArrayList<>());
        Food bread = new Food("Bread", LocalDate.now().plusDays(5), LocalDate.now(), 50, 0.05);
        shop.addProduct(bread);
        List<Food> products = shop.getProducts();
        assertTrue(products.contains(bread));
    }
}