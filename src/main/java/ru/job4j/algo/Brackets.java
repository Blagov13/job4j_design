package ru.job4j.algo;

import java.util.HashMap;
import java.util.Stack;

public class Brackets {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        HashMap<Character, Character> brackets = new HashMap<>();
        brackets.put('(', ')');
        brackets.put('{', '}');
        brackets.put('[', ']');
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (brackets.containsKey(c)) {
                stack.push(c);
            } else if (brackets.containsValue(c)) {
                if (stack.isEmpty() || brackets.get(stack.pop()) != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
