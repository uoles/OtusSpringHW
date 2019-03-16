package ru.otus.mkulikov.registration;

import ru.otus.mkulikov.model.User;

import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

public class RegistrationImpl implements Registration {

    private User user;

    @Override
    public void addNewUser(Scanner in) {
        System.out.println("Введите свои данные");
        System.out.println("Фамилия: ");
        String surname = in.nextLine();

        System.out.println("Имя: ");
        String name = in.nextLine();

        user = new User(name, surname);
        System.out.println(String.format("Здравствуйте, %s %s!", surname, name));
    }

    @Override
    public User getUser() {
        return user;
    }
}
