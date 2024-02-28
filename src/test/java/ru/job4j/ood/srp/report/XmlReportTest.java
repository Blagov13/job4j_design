package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemoryStore;

import javax.xml.bind.JAXBException;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class XmlReportTest {
    @Test
    void testGenerate() throws JAXBException {
        MemoryStore store = new MemoryStore();
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker1 = new Employee("Alex", now, now, 200);
        Employee worker2 = new Employee("Gena", now, now, 300);
        store.add(worker);
        store.add(worker1);
        store.add(worker2);
        Report report = new XmlReport(store);
        String s = System.lineSeparator();
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>").append(s)
                .append("<employees>").append(s).append("\t")
                .append(String.format("<employee name=\"%s\" ", worker.getName()))
                .append(String.format("hired=\"%s\" ", dateTimeParser.parse(worker.getHired())))
                .append(String.format("fired=\"%s\" ", dateTimeParser.parse(worker.getFired())))
                .append(String.format("salary=\"%s\"/>", worker.getSalary())).append(s)
                .append(String.format("<employee name=\"%s\" ", worker1.getName()))
                .append(String.format("hired=\"%s\" ", dateTimeParser.parse(worker1.getHired())))
                .append(String.format("fired=\"%s\" ", dateTimeParser.parse(worker1.getFired())))
                .append(String.format("salary=\"%s\"/>", worker1.getSalary())).append(s)
                .append(String.format("<employee name=\"%s\" ", worker2.getName()))
                .append(String.format("hired=\"%s\" ", dateTimeParser.parse(worker2.getHired())))
                .append(String.format("fired=\"%s\" ", dateTimeParser.parse(worker2.getFired())))
                .append(String.format("salary=\"%s\"/>", worker2.getSalary())).append(s)
                .append("</employees>").append(s);
        assertThat(report.generate(em -> true)).isEqualToIgnoringWhitespace(expect.toString());
    }
}