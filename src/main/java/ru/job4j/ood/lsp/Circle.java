package ru.job4j.ood.lsp;

public class Circle extends Shape {
  /*  Этот пример нарушает LSP, потому что подкласс Circle возвращает значение,
    отличное от ожидаемого от родительского класса Shape.*/
    @Override
    public int calculateArea(int width, int height) {
        return width * width;
    }
}

