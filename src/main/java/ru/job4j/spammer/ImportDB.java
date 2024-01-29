package ru.job4j.spammer;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ImportDB {
    private final Properties config;
    private final String dump;

    public ImportDB(Properties config, String dump) {
        this.config = config;
        this.dump = dump;
    }

    public List<User> load() throws IllegalArgumentException, IOException {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dump))) {
            String read;
            while ((read = reader.readLine()) != null) {
                String[] line = read.split(";");
                if (line.length != 2 || line[1].startsWith(";")) {
                    throw new IllegalArgumentException();
                }
                users.add(new User(line[0], line[1]));
            }
        }
        return users;
    }
        /*try (Stream<String> lines = Files.lines(Paths.get(dump))) {
            lines.filter(line -> !line.isEmpty() && line.indexOf(";") != line.lastIndexOf(";")
                            && !line.equals(";;")
                            && StringUtils.split(line, ";").length <= 2)
                    .forEach(line -> users.add(new User(line.split(";")[0], line.split(";")[1])));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        return users;*/

    public void save(List<User> users) throws ClassNotFoundException, SQLException {
        Class.forName(config.getProperty("jdbc.driver"));
        try (Connection connection = DriverManager.getConnection(
                config.getProperty("jdbc.url"),
                config.getProperty("jdbc.username"),
                config.getProperty("jdbc.password")
        )) {
            for (User user : users) {
                try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users(name, email) VALUES (?, ?)")) {
                    preparedStatement.setString(1, user.name);
                    preparedStatement.setString(2, user.email);
                    preparedStatement.execute();
                }
            }
        }
    }

    private static class User {
        String name;
        String email;

        public User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        try (InputStream input = ImportDB.class.getClassLoader().getResourceAsStream(
                "spammer.properties")) {
            config.load(input);
        }
        ImportDB dataBase = new ImportDB(config, "/Users/aleksandrblagov/job4j_design/data/dump.txt");
        dataBase.save(dataBase.load());
    }
}
