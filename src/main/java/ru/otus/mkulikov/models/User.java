package ru.otus.mkulikov.models;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:29
 */

public class User {

    @Setter
    @Getter
    private final String name;
    @Setter
    @Getter
    private final String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
