package ru.job4j.ood.lsp.storage;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class TrashTest {  @Test
public void testAddProduct() {
    Trash trash = new Trash(new ArrayList<>());
    Food chicken = new Food("Chicken", LocalDate.now().minusDays(2),
            LocalDate.now().minusDays(7), 200, 0.2);
    trash.addProduct(chicken);
    List<Food> products = trash.getProducts();
    assertTrue(products.contains(chicken));
}
}