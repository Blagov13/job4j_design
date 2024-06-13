package ru.job4j.algo;

import java.util.Comparator;
import java.util.List;

public class QuickList {
    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> sequence, int start, int end, Comparator<T> comparator) {
        if (start < end) {
            int partitionIndex = breakPartition(sequence, start, end, comparator);
            quickSort(sequence, start, partitionIndex - 1, comparator);
            quickSort(sequence, partitionIndex + 1, end, comparator);
        }
    }

    private static <T> int breakPartition(List<T> sequence, int start, int end, Comparator<T> comparator) {
        T beginToend = sequence.get(end);
        int suppotElement = start - 1;
        for (int i = start; i < end; i++) {
            if (comparator.compare(sequence.get(i), beginToend) <= 0) {
                suppotElement++;
                swap(sequence, suppotElement, i);
            }
        }
        swap(sequence, suppotElement + 1, end);
        return suppotElement + 1;
    }

    private static <T> void swap(List<T> array, int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }
}
