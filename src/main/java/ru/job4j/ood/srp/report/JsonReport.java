package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.formatter.CalendarJSON;
import ru.job4j.ood.srp.formatter.DateFormatter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.model.Employees;
import ru.job4j.ood.srp.store.Store;

import java.util.GregorianCalendar;
import java.util.function.Predicate;

public class JsonReport implements Report {
    private final Store store;
    private final DateFormatter dateFormatter;
    private final Gson gson;

    public JsonReport(Store store, DateFormatter dateFormatter) {
        this.store = store;
        this.dateFormatter = dateFormatter;
        this.gson = new GsonBuilder().registerTypeAdapter(GregorianCalendar.class, new CalendarJSON())
                .create();
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        Employees employees = new Employees(store.findBy(filter));
        return gson.toJson(employees);
    }
}
