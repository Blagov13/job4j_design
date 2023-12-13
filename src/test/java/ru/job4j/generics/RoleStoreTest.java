package ru.job4j.generics;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class RoleStoreTest {
    @Test
    void whenAddAndFindThenRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("3", "Alex"));
        Role result = store.findById("3");
        assertThat(result.getRoleName()).isEqualTo("Alex");
    }

    @Test
    void whenReplaceThenRoleNameIsAlex() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Petr"));
        store.replace("1", new Role("1", "Alex"));
        Role result = store.findById("1");
        assertThat(result.getRoleName()).isEqualTo("Alex");
    }

    @Test
    void whenDeleteUserThenUserIsNull() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        store.delete("1");
        Role result = store.findById("1");
        assertThat(result).isNull();
    }

    @Test
    void whenReplaceOkThenTrue() {
        RoleStore store = new RoleStore();
        store.add(new Role("1", "Alex"));
        boolean result = store.replace("1", new Role("1", "Maxim"));
        assertThat(result).isTrue();
    }
}