package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class ControlQualityTest {
    @Test
    public void testRedistribute() {
        List<Store> stores = new ArrayList<>();
        Warehouse warehouse = new Warehouse(new ArrayList<>());
        Shop shop = new Shop(new ArrayList<>());
        Trash trash = new Trash(new ArrayList<>());
        stores.add(warehouse);
        stores.add(shop);
        stores.add(trash);

        Food milk = new Food("Milk", LocalDate.now().plusDays(20),
                LocalDate.now(), 100, 0.1);
        Food bread = new Food("Bread", LocalDate.now().plusDays(5),
                LocalDate.now(), 50, 0.05);
        Food chicken = new Food("Chicken", LocalDate.now().minusDays(2),
                LocalDate.now().minusDays(7), 200, 0.2);

        warehouse.addProduct(milk);
        shop.addProduct(bread);
        trash.addProduct(chicken);

        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.redistribute();

        assertTrue(warehouse.getProducts().contains(milk));
        assertTrue(shop.getProducts().contains(bread));
        assertTrue(trash.getProducts().contains(chicken));
    }
}