package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

class ControlQualityTest {
    @Test
    void testRedistributeToWarehouse() {
        Warehouse warehouse = new Warehouse();
        ControlQuality controlQuality = new ControlQuality(List.of(warehouse));
        LocalDate currentDate = LocalDate.now();
        Food food1 = new Food("Apple", currentDate.plusDays(5),
                currentDate.minusDays(15), 10.0, 0.1);

        controlQuality.redistribute(food1);

        assertEquals(1, warehouse.getProducts().size());
        assertEquals("Apple", warehouse.getProducts().get(0).getName());
    }

    @Test
    void testRedistributeToShop() {
        Shop shop = new Shop();
        ControlQuality controlQuality = new ControlQuality(List.of(shop));
        LocalDate currentDate = LocalDate.now();
        Food food1 = new Food("Banana", currentDate.plusDays(10),
                currentDate.minusDays(5), 8.0, 0.2);

        controlQuality.redistribute(food1);

        assertEquals(1, shop.getProducts().size());
        assertEquals("Banana", shop.getProducts().get(0).getName());
    }

    @Test
    void testRedistributeToTrash() {
        Trash trash = new Trash();
        ControlQuality controlQuality = new ControlQuality(List.of(trash));
        LocalDate currentDate = LocalDate.now();
        Food food1 = new Food("Milk", currentDate.minusDays(1),
                currentDate.minusDays(10), 5.0, 0.1);

        controlQuality.redistribute(food1);

        assertEquals(1, trash.getProducts().size());
        assertEquals("Milk", trash.getProducts().get(0).getName());
    }
}