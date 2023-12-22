package ru.job4j.tree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Room {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> keySet = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        keySet.add(0);
        while (!keySet.isEmpty()) {
            int key = keySet.iterator().next();
            keySet.remove(key);
            if (!visited.contains(key)) {
                keySet.addAll(rooms.get(key));
                visited.add(key);
            }
        }
        return visited.size() == rooms.size();
    }
}
