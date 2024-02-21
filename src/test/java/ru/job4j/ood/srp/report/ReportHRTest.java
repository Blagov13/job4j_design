package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportHRTest {
    @Test
    public void whenHRReportGenerated() {
        MemoryStore store = new MemoryStore();
        Employee workerIvan = new Employee("Ivan", Calendar.getInstance(), Calendar.getInstance(), 150);
        Employee workerPetr = new Employee("Petr", Calendar.getInstance(), Calendar.getInstance(), 100);
        Employee workerAlex = new Employee("Alex", Calendar.getInstance(), Calendar.getInstance(), 200);
        store.add(workerIvan);
        store.add(workerPetr);
        store.add(workerAlex);
        HRReport engine = new HRReport(store);
        String expected = "Name: Alex, Salary: 200.0" + System.lineSeparator()
                + "Name: Ivan, Salary: 150.0" + System.lineSeparator()
                + "Name: Petr, Salary: 100.0";
        assertThat(engine.generate(emp -> true)).isEqualTo(expected);
    }
}
