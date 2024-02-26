package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TrashTest {
    @Test
    public void testAddProduct() {
        Trash trash = new Trash();
        Food product = new Food("Chicken", LocalDate.now().minusDays(2),
                LocalDate.now().minusDays(7), 200, 0.2);
        trash.addProduct(product);
        assertTrue(trash.getProducts().contains(product));
    }
}