package ru.job4j.ood.lsp;

public class Car extends Vehicle {
    /*Этот пример нарушает LSP, поскольку подкласс Car
    изменяет возвращаемое значение.*/
    @Override
    public int getSpeed() {
        return 120;
    }
}

