package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Analize {
    public static Info diff(Set<User> previous, Set<User> current) {
        Info info = new Info(0, 0, 0);
        Map<Integer, String> map = new HashMap<>();
        for (User user : current) {
            map.put(user.getId(), user.getName());
        }
        for (User user : previous) {
            if (!map.containsKey(user.getId())) {
                info.setDeleted(info.getDeleted() + 1);
            }
            if (map.containsKey(user.getId())
                    && !Objects.equals(map.get(user.getId()), user.getName())) {
                info.setChanged(info.getChanged() + 1);
            }
        }
        int rsl = current.size() - previous.size() + info.getDeleted();
        info.setAdded(info.getAdded() + rsl);
        return info;
    }
}