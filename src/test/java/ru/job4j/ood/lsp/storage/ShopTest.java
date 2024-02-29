package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ShopTest {
    @Test
    public void whenProductAddWithDiscount() {
        Shop shop = new Shop();
        LocalDate expiryDate = LocalDate.now().plusDays(30);
        Food product = new Food("Bread", LocalDate.now().minusDays(10), expiryDate, 80.0, 0.2);

        boolean result = shop.supports(product);

        assertTrue(result);
        assertEquals(76.8, product.getPrice(), 0.01);
    }
}