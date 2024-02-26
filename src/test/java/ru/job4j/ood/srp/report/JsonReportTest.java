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
        store.add(new Employee("John Doe", Calendar.getInstance(), Calendar.getInstance(), 5000.0));
        store.add(new Employee("Jane Smith", Calendar.getInstance(), Calendar.getInstance(), 6000.0));
        JsonReport jsonReport = new JsonReport(store, new DateFormatter(dateTimeParser));
        String json = jsonReport.generate(employee -> true);
        assertThat(json).contains("John Doe", "Jane Smith");
    }
}