package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class NameLoadTest {
    @Test
    void checkEmpty() {
        NameLoad nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("no data");
    }

    @Test
    void checkContainEqualsException() {
        NameLoad nameLoad = new NameLoad();
        String name1 = "1=true";
        String name2 = "2False";

        assertThatThrownBy(() -> nameLoad.parse(name1, name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain the symbol '='", name2));
    }

    @Test
    void checkContainKeyException() {
        NameLoad nameLoad = new NameLoad();
        String name1 = "1=true";
        String name2 = "=False";

        assertThatThrownBy(() -> nameLoad.parse(name1, name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a key", name2));
    }

    @Test
    void checkContainValueException() {
        NameLoad nameLoad = new NameLoad();
        String name1 = "1=";
        String name2 = "2=true";

        assertThatThrownBy(() -> nameLoad.parse(name1, name2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(String.format("this name: %s does not contain a value", name1));
    }
}