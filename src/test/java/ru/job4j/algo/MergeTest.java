package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {
    @Test
    void whenSortedThenOk() {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        assertThat(Merge.mergesort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }

    @Test
    void whenSortedThenNotEven() {
        int[] array = {2, 5, 7, -8, 6, 11, 17};
        assertThat(Merge.mergesort(array)).containsExactly(-8, 2, 5, 6, 7, 11, 17);
    }
}