package ru.job4j.ood.srp.report;

import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class HRReport {
    private final Store store;

    public HRReport(Store store) {
        this.store = store;
    }

    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store.findBy(filter);
        employees.sort(Comparator.comparing(Employee::getSalary).reversed());
        return employees.stream()
                .map(employee -> "Name: " + employee.getName() + ", Salary: " + employee.getSalary())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
