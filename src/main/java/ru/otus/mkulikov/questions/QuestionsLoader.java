package ru.otus.mkulikov.questions;

import ru.otus.mkulikov.model.Question;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:41
 */

public interface QuestionsLoader {

    void loadFile() throws FileNotFoundException, URISyntaxException;

    List<Question> getQuestions();
}
