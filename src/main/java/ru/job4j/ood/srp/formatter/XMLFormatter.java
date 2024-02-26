package ru.job4j.ood.srp.formatter;

import ru.job4j.ood.srp.model.Employee;

import java.util.Calendar;

public class XMLFormatter {
    private final DateTimeParser<Calendar> dateTimeParser;

    public XMLFormatter(DateTimeParser<Calendar> dateTimeParser) {
        this.dateTimeParser = dateTimeParser;
    }

    public String formatEmployee(Employee employee) {
        String formattedDate = "Hired: " + dateTimeParser.parse(employee.getHired())
                + ", Fired: " + dateTimeParser.parse(employee.getFired());
        return "<Employee><Name>" + employee.getName()
                + "</Name><Dates>" + formattedDate
                + "</Dates><Salary>" + employee.getSalary() + "</Salary></Employee>";
    }
}
