package ru.otus.mkulikov.questions;

import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.model.Question;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:41
 */

public interface QuestionsDAO {

    List<Question> getQuestions(String csvFilename) throws QuestionsFileLoadingException;
}
