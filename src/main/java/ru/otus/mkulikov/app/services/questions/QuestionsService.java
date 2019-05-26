package ru.otus.mkulikov.app.services.questions;

import ru.otus.mkulikov.app.exceptions.QuestionsFileLoadingException;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:41
 */

public interface QuestionsService {

    void showQuestions() throws QuestionsFileLoadingException;
}
