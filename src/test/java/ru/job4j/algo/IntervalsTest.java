package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class IntervalsTest {
    @Test
    public void whenIntervalsHaveOverlapsThenMergeOverlappingIntervals() {
        Intervals intervals = new Intervals();
        int[][] interval = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] expected = new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } };
        int[][] result = intervals.merge(interval);
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    public void whenIntervalsTouchAtEdgesThenMergeIntervals() {
        Intervals intervals = new Intervals();
        int[][] interval = new int[][] { { 1, 4 }, { 4, 5 } };
        int[][] expected = new int[][] { { 1, 5 } };
        int[][] result = intervals.merge(interval);
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    public void whenIntervalsAreNonOverlappingThenReturnSameIntervals() {
        Intervals intervals = new Intervals();
        int[][] interval = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] expected = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 } };
        int[][] result = intervals.merge(interval);
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    public void whenIntervalsFullyOverlapThenMergeIntoOneInterval() {
        Intervals intervals = new Intervals();
        int[][] interval = new int[][] { { 1, 5 }, { 2, 6 }, { 3, 7 } };
        int[][] expected = new int[][] { { 1, 7 } };
        int[][] result = intervals.merge(interval);
        assertThat(result).isDeepEqualTo(expected);
    }

    @Test
    public void whenIntervalsAreMixedThenMergeOverlappingAndKeepNonOverlapping() {
        Intervals intervals = new Intervals();
        int[][] interval = new int[][] { { 1, 4 }, { 0, 2 }, { 3, 5 } };
        int[][] expected = new int[][] { { 0, 5 } };
        int[][] result = intervals.merge(interval);
        assertThat(result).isDeepEqualTo(expected);
    }
}