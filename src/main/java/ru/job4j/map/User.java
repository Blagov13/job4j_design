package ru.job4j.map;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private static Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> map = new HashMap<>(16);
        User alex = new User("Aleksandr", 3, birthday);
        User alex1 = new User("Aleksandr", 3, birthday);
        int hashCode = alex.hashCode();
        int hash = hashCode ^ (hashCode >>> 16);
        int bucket = hash & 15;
        int hashCode1 = alex1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;
        map.put(alex, new Object());
        map.put(alex1, new Object());
        System.out.printf("alex - хешкод: %s, хеш: %s, бакет: %s , ", hashCode, hash, bucket);
        System.out.printf("alex1 - хешкод: %s, хеш: %s, бакет: %s", hashCode1, hash1, bucket1);
    }
}
