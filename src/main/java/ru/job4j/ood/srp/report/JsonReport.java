package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import ru.job4j.ood.srp.formatter.DateFormatter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;
    private final DateFormatter dateFormatter;
    private final Gson gson;

    public JsonReport(Store store, DateFormatter dateFormatter) {
        this.store = store;
        this.dateFormatter = dateFormatter;
        this.gson = new Gson();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> filteredEmployees = store.findBy(filter);
        List<String> formattedEmployees = new ArrayList<>();
        for (Employee employee : filteredEmployees) {
            formattedEmployees.add(dateFormatter.formatEmployee(employee));
        }
        return gson.toJson(formattedEmployees);
    }
}
