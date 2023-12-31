package ru.job4j.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;

class AnalysisTest {

    @Test
    void time(@TempDir Path tempDir) throws IOException {
        File sourse = tempDir.resolve("source.log").toFile();
        try (PrintWriter out = new PrintWriter(sourse)) {
            out.println("200 10:56:01");
            out.println("500 10:57:01");
            out.println("400 10:58:01");
            out.println("500 10:59:01");
            out.println("400 11:01:02");
            out.println("300 11:02:02");
        }
        File target1 = tempDir.resolve("target1.csv").toFile();
        Analysis analysis = new Analysis();
        analysis.unavailable(sourse.getAbsolutePath(), target1.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target1))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("10:57:01;11:02:02;").hasToString(rsl.toString());
    }

}