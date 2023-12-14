package ru.job4j.iterator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.Predicate;

class ListUtilsTest {
    private List<Integer> input;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenRemoveIf() {
        input.addAll(List.of(2, 4, 5, 6, 8));
        Predicate predicate = t -> (Integer) t % 2 == 0;
        ListUtils.removeIf(input, predicate);
        assertThat(input).containsExactly(1, 3, 5).hasSize(3);

    }

    @Test
    void whenReplaceIf1To7() {
        input.addAll(List.of(2, 1, 4, 1, 1));
        Predicate predicate = t -> (Integer) t == 1;
        ListUtils.replaceIf(input, predicate, 7);
        assertThat(input).doesNotContain(1);
    }

    @Test
    void whenRemoveAll() {
        input.addAll(List.of(2, 3, 4, 5));
        ListUtils.removeAll(input, List.of(3, 5));
        assertThat(input).hasSize(3).containsExactly(1, 2, 4);
    }
}