package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WarehouseTest {
    @Test
    public void testAddProduct() {
        Warehouse warehouse = new Warehouse();
        Food product = new Food("Milk", LocalDate.now().plusDays(20),
                LocalDate.now(), 100, 0.1);
        warehouse.addProduct(product);
        assertTrue(warehouse.getProducts().contains(product));
    }
}