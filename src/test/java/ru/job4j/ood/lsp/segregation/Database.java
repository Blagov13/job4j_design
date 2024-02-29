package ru.job4j.ood.lsp.segregation;

public interface Database {
    /*����� ��� ������ � ����� ������ �������� ������ ���������� SQL  ��������, �������� � �������� �����������*/
    void executeQuery(String query);
    void openConnection();
    void closeConnection();
}
