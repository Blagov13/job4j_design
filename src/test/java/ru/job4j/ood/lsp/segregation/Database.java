package ru.job4j.ood.lsp.segregation;

public interface Database {
    /*Класс для работы с базой данных содержит методы выполнения SQL  запросов, создания и закрытия подключений*/
    void executeQuery(String query);
    void openConnection();
    void closeConnection();
}
