package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {
    public static int[] findSmallestRange(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return null;
        }
        int[] count = new int[nums[nums.length - 1] + 1];
        int left = 0, right = 0;
        int unique = 0;
        int min = Integer.MAX_VALUE;
        int[] rsl = new int[2];
        while (right < nums.length) {
            if (count[nums[right]] == 0) {
                unique++;
            }
            count[nums[right]]++;
            right++;
            while (unique >= k) {
                if (right - left < min) {
                    min = right - left;
                    rsl[0] = left;
                    rsl[1] = right - 1;
                }
                count[nums[left]]--;
                if (count[nums[left]] == 0) {
                    unique--;
                }
                left++;
            }
        }
        return min == Integer.MAX_VALUE ? null : rsl;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9};
        int k = 3;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует.");
        }
    }
}
