package ru.job4j.algo;

import java.util.Arrays;

import static java.lang.Integer.sum;

public class Merge {
    public static int[] mergesort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergesort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergesort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int n = sum(left.length, right.length);
        int indexLeft = 0;
        int indexRight = 0;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            if (indexLeft < left.length && (indexRight >= right.length || left[indexLeft] < right[indexRight])) {
                array[i] = left[indexLeft];
                indexLeft++;
            } else {
                array[i] = right[indexRight];
                indexRight++;
            }
        }
        return array;
    }
}
