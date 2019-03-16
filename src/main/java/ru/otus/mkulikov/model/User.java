package ru.otus.mkulikov.model;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:29
 */

public class User {

    private final String name;
    private final String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    @Override
    public String toString() {
        return "User {" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
