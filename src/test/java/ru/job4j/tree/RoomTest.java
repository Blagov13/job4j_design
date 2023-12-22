package ru.job4j.tree;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RoomTest {
    @Test
    void canNotVisitAllRooms() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(0, Arrays.asList(1, 3));
        rooms.add(1, Arrays.asList(3, 0, 1));
        rooms.add(2, List.of(2));
        rooms.add(3, List.of(0));
        assertThat(new Room().canVisitAllRooms(rooms)).isFalse();
    }

    @Test
    void canVisitAllRooms() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(0, List.of(1));
        rooms.add(1, List.of(2));
        rooms.add(2, List.of(3));
        rooms.add(3, List.of());
        assertThat(new Room().canVisitAllRooms(rooms)).isTrue();
    }
}
