package ru.otus.mkulikov.processor;

import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

public interface ProcessorService {

    void startTest() throws QuestionsFileLoadingException;
}
