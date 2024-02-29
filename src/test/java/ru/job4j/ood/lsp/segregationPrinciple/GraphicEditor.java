package ru.job4j.ood.lsp.segregationPrinciple;

public interface GraphicEditor {
    /*Интерфейс содержит методы для создания нового документа, открытия файла, рисования фигур*/
    void drawFigure();
    void createDocument();
    void openFile();
}
