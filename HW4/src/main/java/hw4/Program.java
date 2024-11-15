package hw4;

import models.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate.
 * Создайте несколько объектов Person и сохраните их в базу данных.
 */
public class Program {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "password";

        // Подключение к базе данных
        try(Connection connection = DriverManager.getConnection(url, user, password)){

            // Создание базы данных
            createDatabase(connection);
            System.out.println("Database created successfully");

            // Использование базы данных
            useDatabase(connection);
            System.out.println("Use database successfully");

            // Создание таблицы
            createTable(connection);
            System.out.println("Create table successfully");

            Person person1 = new Person("Василий", 44);
            Person person2 = new Person("Ирина", 34);
            Person person3 = new Person("Аглая", 40);

            // Добавление данных
            insertData(connection, person1);
            insertData(connection, person2);
            insertData(connection, person3);
            System.out.println("Insert data successfully");

            // Закрытие соединения
//            connection.close();
//            System.out.println("Database connection close successfully");
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }

    //region Вспомогательные методы

    private static void createDatabase(Connection connection) throws SQLException {
        String createDatabaseSQL =  "CREATE DATABASE IF NOT EXISTS personDB;";
        try (PreparedStatement statement = connection.prepareStatement(createDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void useDatabase(Connection connection) throws SQLException {
        String useDatabaseSQL =  "USE personDB;";
        try (PreparedStatement statement = connection.prepareStatement(useDatabaseSQL)) {
            statement.execute();
        }
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS persons (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(255), age INT);";
        try (PreparedStatement statement = connection.prepareStatement(createTableSQL)) {
            statement.execute();
        }
    }

    private static void insertData(Connection connection, Person person) throws SQLException {
        String insertDataSQL = "INSERT INTO persons (name, age) VALUES (?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(insertDataSQL)) {
            statement.setString(1, person.getName());
            statement.setInt(2, person.getAge());
            statement.executeUpdate();
        }
    }
}
