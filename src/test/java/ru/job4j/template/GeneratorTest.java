package ru.job4j.template;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class GeneratorTest {
    @Test
    public void whenGivenValidTemplateAbdMapThenReplaceKeysWithValues() {
        Generator generator = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}? ";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Alex Blagov");
        values.put("subject", "you");
        String exp = "I am a Alex Blagov, Who are you? ";
        String rsl = generator.produce(template, values);
        assertEquals(exp, rsl);
    }

    @Test
    public void whenTemplateContainsMissingKeyThenThrowException() {
        Generator generator = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Alex Blagov");
        assertThatThrownBy(() -> generator.produce(template, values))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void whenMapContainsExtraKeyThenThrowException() {
        Generator generator = new GeneratorTemplate();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> values = new HashMap<>();
        values.put("name", "Alex Blagov");
        values.put("subject", "you");
        values.put("age", "30");
        assertThatThrownBy(() -> generator.produce(template, values))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
