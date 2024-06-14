package ru.job4j.algo.sliding.window;

public class Event implements Comparable<Event> {
    int time;
    boolean isStart;

    public Event(int time, boolean isStart) {
        this.isStart = isStart;
        this.time = time;
    }

    @Override
    public int compareTo(Event other) {
        if (this.time == other.time) {
            /*Стартовые события предшествуют конечным событиям, если они происходят одновременно*/
            return this.isStart ? -1 : 1;
        }
        return Integer.compare(this.time, other.time);
    }
}
