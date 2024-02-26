package ru.job4j.ood.ocp;

public class FileManager {
   /* Нарушение OCP: Если потребуется добавить поддержку
    других типов файлов (например, изображения), метод `openFile` потребует изменений.*/
    public void openFile(String filePath) {
    }
}
