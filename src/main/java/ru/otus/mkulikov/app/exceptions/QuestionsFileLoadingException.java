package ru.otus.mkulikov.app.exceptions;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-17
 * Time: 01:40
 */

public class QuestionsFileLoadingException extends RuntimeException {

    public QuestionsFileLoadingException(String message) {
        super(message);
    }

    public QuestionsFileLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
