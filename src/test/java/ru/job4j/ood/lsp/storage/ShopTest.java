package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ShopTest {
    @Test
    public void testAddProduct() {
        Shop shop = new Shop();
        Food product = new Food("Apple", LocalDate.now().plusDays(20),
                LocalDate.now(), 80, 0.15);
        shop.addProduct(product);
        assertTrue(shop.getProducts().contains(product));
    }
}