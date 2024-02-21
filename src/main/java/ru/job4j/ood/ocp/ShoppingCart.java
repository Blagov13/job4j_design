package ru.job4j.ood.ocp;

import java.util.ArrayList;

public class ShoppingCart {
    /*Нарушение OCP: Если понадобится добавить скидки
    или налоги к покупке, потребуется изменить метод `calculateTotalPrice`.*/
    public double calculateTotalPrice(ArrayList<Item> items) {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
/*Добавил внутренний класс, чтобы Idea не ругалась*/
    private class Item {
        public double getPrice() {
            return 0;
        }
    }
}
