package ru.job4j.ood.dip;

public class ReportGenerator {
    private DatabaseConnection dbConnection = new DatabaseConnection();

    public void generateReport() {
        dbConnection.openConnection();
        dbConnection.closeConnection();
    }

    /*Непосредственное создание экземпляра зависимого класса внутри класса*/
}
