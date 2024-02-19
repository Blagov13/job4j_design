package ru.job4j.kiss.fool;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;


class FoolTest {
    @Test
    void whenFizzBuzz() {
        assertThat(Fool.validate(15)).isEqualTo("FizzBuzz");
    }

    @Test
    void whenFizz() {
        assertThat(Fool.validate(6)).isEqualTo("Fizz");
    }
}