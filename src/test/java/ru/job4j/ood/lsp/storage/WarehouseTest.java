package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class WarehouseTest {
    @Test
    public void testAddProduct() {
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Food milk = new Food("Milk", LocalDate.now().plusDays(20),
                LocalDate.now(), 100, 0.1);
        warehouse.addProduct(milk);
        List<Food> products = warehouse.getProducts();
        assertTrue(products.contains(milk));
    }
}