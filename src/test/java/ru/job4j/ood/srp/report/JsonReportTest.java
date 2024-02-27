package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateFormatter;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;
import ru.job4j.ood.srp.store.Store;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class JsonReportTest {
    @Test
    void testGenerate() {
        Store store = new MemoryStore();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        JsonReport jsonReport = new JsonReport(store, new DateFormatter(dateTimeParser));
        StringBuilder expect = new StringBuilder()
                .append(String.format("{\"employees\":[{\"name\":\"%s\",", worker.getName()))
                .append(String.format("\"hired\":\"%s\",", dateTimeParser.parse(worker.getHired())))
                .append(String.format("\"fired\":\"%s\",", dateTimeParser.parse(worker.getFired())))
                .append(String.format("\"salary\":%s}]}", worker.getSalary()));
        assertThat(jsonReport.generate(employee -> true)).isEqualToIgnoringWhitespace(expect.toString());
    }
}