package ru.otus.mkulikov.registration;

import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

public interface RegistrationService {

    void addNewUser() throws QuestionsFileLoadingException;
}
