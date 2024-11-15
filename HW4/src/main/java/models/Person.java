package models;

import java.util.Random;

/**
 * Настройте связь между вашим приложением и базой данных MySQL с использованием Hibernate.
 * Создайте несколько объектов Person и сохраните их в базу данных.
 */

public class Person {

    public static Random random = new Random();

    private Long id;
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static Person create(String name, int age) {
        return new Person(name, age);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
