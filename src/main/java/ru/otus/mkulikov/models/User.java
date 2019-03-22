package ru.otus.mkulikov.models;

import lombok.Data;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:29
 */

@Data
public class User {

    private final String name;
    private final String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
