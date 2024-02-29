package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class TrashTest {
    @Test
    void testSupports() {
        Trash trash = new Trash();
        LocalDate currentDate = LocalDate.now();
        Food milk = new Food("Milk", currentDate.minusDays(1),
                currentDate.minusDays(10), 5.0, 0.1);

        boolean result = trash.supports(milk);

        assertTrue(result);
    }
}