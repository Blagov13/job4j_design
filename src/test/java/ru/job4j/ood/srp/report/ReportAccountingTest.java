package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.currency.Currency;
import ru.job4j.ood.srp.currency.InMemoryCurrencyConverter;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.assertThat;

public class ReportAccountingTest {
    @Test
    public void whenAccountingReportGenerated() {
        Currency targetCurrency = Currency.USD;
        Calendar now = Calendar.getInstance();
        MemoryStore store = new MemoryStore();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        InMemoryCurrencyConverter converter = new InMemoryCurrencyConverter();
        AccountingReport engine = new AccountingReport(store, converter, targetCurrency);
        StringBuilder expected = new StringBuilder()
                .append("Name; Salary (")
                .append(targetCurrency).append(");")
                .append(System.lineSeparator())
                .append(worker.getName()).append(" ")
                .append(converter.convert(Currency.RUB, worker.getSalary(), targetCurrency))
                .append(System.lineSeparator());
        assertThat(engine.generate(employee -> true)).isEqualTo(expected.toString());
    }
}
