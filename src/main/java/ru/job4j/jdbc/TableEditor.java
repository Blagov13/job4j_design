package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

import static java.lang.String.format;


public class TableEditor implements AutoCloseable {
    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws SQLException, ClassNotFoundException {
        Class.forName(properties.getProperty("driver_class"));
        String url = properties.getProperty("url");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, username, password);
    }

    public void executeQuery(String tableName, String sql, Connection connection) {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void createTable(String tableName) throws Exception {
        String sql = format(
                "CREATE TABLE IF NOT EXISTS %s(%s);",
                tableName,
                "ID SERIAL PRIMARY KEY"
        );
        executeQuery(tableName, sql, connection);
        System.out.println(getTableScheme(tableName));
    }

    public void dropTable(String tableName) {
        String sql = format(
                "DROP TABLE IF EXISTS %s",
                tableName
        );
        executeQuery(tableName, sql, connection);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = format(
                "ALTER TABLE %s ADD COLUMN IF NOT EXISTS %s %s;",
                tableName,
                columnName,
                type
        );
        executeQuery(tableName, sql, connection);
        System.out.println(getTableScheme(tableName));
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = format(
                "ALTER TABLE %s DROP COLUMN IF EXISTS %s;",
                tableName,
                columnName
        );
        executeQuery(tableName, sql, connection);
        System.out.println(getTableScheme(tableName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;",
                tableName,
                columnName,
                newColumnName
        );
        executeQuery(tableName, sql, connection);
        System.out.println(getTableScheme(tableName));
    }


    public String getTableScheme(String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(format(
                    "SELECT * FROM %s LIMIT 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        String tableName = "test";
        try (InputStream in = TableEditor.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            try (TableEditor tableEditor = new TableEditor(config)) {
                tableEditor.createTable(tableName);
                tableEditor.addColumn(tableName, "column1", "VARCHAR(255)");
                tableEditor.renameColumn(tableName, "column1", "column2");
                tableEditor.dropColumn(tableName, "column2");
                tableEditor.dropTable(tableName);
            }
        }
    }
}
