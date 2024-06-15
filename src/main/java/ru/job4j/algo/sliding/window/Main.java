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
        int maxOverlaps = 0;
        int currentOverlaps = 0;
        int maxOverlapStart = -1;
        int maxOverlapEnd = -1;
        for (Event event : events) {
            if (event.isStart) {
                currentOverlaps++;
                if (currentOverlaps > maxOverlaps) {
                    maxOverlaps = currentOverlaps;
                    maxOverlapStart = event.time;
                }
            } else {
                if (currentOverlaps == maxOverlaps) {
                    maxOverlapEnd = event.time;
                }
                currentOverlaps--;
            }
        }
        return new int[]{maxOverlapStart, maxOverlapEnd};
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
