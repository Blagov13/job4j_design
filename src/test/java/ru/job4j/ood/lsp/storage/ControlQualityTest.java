package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ControlQualityTest {
    @Test
    public void testResort() {
        Warehouse warehouse = new Warehouse();
        Shop shop = new Shop();
        Trash trash = new Trash();

        List<Store> stores = new ArrayList<>(Arrays.asList(warehouse, shop, trash));

        Food milk = new Food("Milk", LocalDate.now().plusDays(20), LocalDate.now(), 100, 0.1);
        Food cheese = new Food("Cheese", LocalDate.now().plusDays(20), LocalDate.now(), 80, 0.15);
        Food yogurt = new Food("Yogurt", LocalDate.now().plusDays(5), LocalDate.now(), 60, 0.1);
        Food bread = new Food("Bread", LocalDate.now().plusDays(5), LocalDate.now(), 50, 0.05);
        Food chicken = new Food("Chicken", LocalDate.now().minusDays(2), LocalDate.now().minusDays(7), 200, 0.2);

        warehouse.addProduct(milk);
        warehouse.addProduct(cheese);
        shop.addProduct(yogurt);
        shop.addProduct(bread);
        trash.addProduct(chicken);

        ControlQuality controlQuality = new ControlQuality(stores);
        controlQuality.resort();

        assertTrue(trash.getProducts().contains(chicken));
        assertTrue(warehouse.getProducts().contains(milk));
        assertTrue(warehouse.getProducts().contains(cheese));
        assertTrue(shop.getProducts().contains(yogurt));
        assertTrue(shop.getProducts().contains(bread));
    }
}