package ru.job4j.ood.lsp.segregationPrinciple;

public interface ResourceManagement {
    /*Интерфейс содержит методы для работы и методы для управления рабочим местом.*/
    void doWork();
    void hire();
    void fire();
    void getSalary();
    void takeVacation();
}
