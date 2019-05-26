package ru.otus.mkulikov.app.services.questions.dao;

import ru.otus.mkulikov.app.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.app.models.Question;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:41
 */

public interface QuestionsDAO {

    List<Question> getQuestions() throws QuestionsFileLoadingException;
}
