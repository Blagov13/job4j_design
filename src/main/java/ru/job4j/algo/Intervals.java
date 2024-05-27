package ru.job4j.algo;

import java.util.Arrays;
import java.util.Comparator;

public class Intervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[][] mergedIntervals = new int[intervals.length][2];
        int mergedIndex = 0;
        mergedIntervals[mergedIndex] = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastMergedInterval = mergedIntervals[mergedIndex];
            if (currentInterval[0] <= lastMergedInterval[1]) {
                lastMergedInterval[1] = Math.max(lastMergedInterval[1], currentInterval[1]);
            } else {
                mergedIndex++;
                mergedIntervals[mergedIndex] = currentInterval;
            }
        }
        return Arrays.copyOfRange(mergedIntervals, 0, mergedIndex + 1);
    }
}
