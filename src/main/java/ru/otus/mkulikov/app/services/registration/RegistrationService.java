package ru.otus.mkulikov.app.services.registration;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

public interface RegistrationService {

    void addNewUser();

    boolean addNewUser(String userName, String userSurname);
}
