package ru.job4j.ood.srp.formatter;

import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;

public class DateFormatter {
    private final DateTimeParser<Calendar> dateTimeParser;

    public DateFormatter(DateTimeParser<Calendar> dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public String formatEmployee(Employee employee) {
        return "Name: " + employee.getName()
                + ", Hired: " + dateTimeParser.parse(employee.getHired())
                + ", Fired: " + dateTimeParser.parse(employee.getFired())
                + ", Salary: " + employee.getSalary();
    }
}
