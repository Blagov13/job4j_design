package ru.job4j.algo.sliding.window;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        List<Event> events = new ArrayList<>();
        for (Interval interval : intervals) {
            events.add(new Event(interval.start, true));
            events.add(new Event(interval.end, false));
        }
        Collections.sort(events);
        int currentOverlap = 0;
        int maxOverlap = 0;
        int start = -1;
        int end = -1;
        for (Event event : events) {
            if (event.isStart) {
                currentOverlap++;
                if (currentOverlap > maxOverlap) {
                    maxOverlap = currentOverlap;
                    start = event.time;
                    end = event.time;
                }
            } else {
                if (currentOverlap == maxOverlap) {
                    end = event.time;
                }
                currentOverlap--;
            }
        }
        return new int[]{start, end};
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));
        int[] result = findMaxOverlapInterval(intervals);
        System.out.println("Интервал, перекрывающий максимальное количество интервалов: [" + result[0] + ", " + result[1] + "]");
    }
}
