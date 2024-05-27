package ru.job4j.algo.hash;

import java.util.HashMap;

public class LongestUniqueSubstring {
    public static String longestUniqueSubstring(String str) {
        if (str.isEmpty()) {
            return "";
        }
        HashMap<Character, Integer> charIndex = new HashMap<>();
        int begin = 0;
        int maxLenght = 0;
        int maxStart = 0;
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (charIndex.containsKey(currentChar) && charIndex.get(currentChar) >= begin) {
                begin = charIndex.get(currentChar) + 1;
            }
            charIndex.put(currentChar, i);
            if (i - begin + 1 > maxLenght) {
                maxLenght = i - begin + 1;
                maxStart = begin;
            }
        }
        return str.substring(maxStart, maxStart + maxLenght);
    }
}
