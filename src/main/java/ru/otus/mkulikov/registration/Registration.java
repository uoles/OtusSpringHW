package ru.otus.mkulikov.registration;

import ru.otus.mkulikov.model.User;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

public interface Registration {

    void addNewUser(Scanner in);

    User getUser();
}
