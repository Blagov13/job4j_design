package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class WarehouseTest {
    @Test
    void testSupports() {
        Warehouse warehouse = new Warehouse();
        LocalDate currentDate = LocalDate.now();
        Food food1 = new Food("Apple", currentDate.plusDays(15),
                currentDate.minusDays(5), 10.0, 0.1);

        boolean result = warehouse.supports(food1);

        assertTrue(result);
    }
}