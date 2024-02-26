package ru.job4j.ood.lsp;

public class Square extends Rectangle {
    /*Этот пример нарушает LSP, потому что методы setWidth и setHeight
    в подклассе Square ведут себя иначе, чем в родительском классе Rectangle.*/
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}