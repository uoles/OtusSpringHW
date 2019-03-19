package ru.otus.mkulikov.exceptions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-18
 * Time: 11:39
 */

@DisplayName("Класс исключения QuestionsFileLoadingException")
class QuestionsFileLoadingExceptionTest {

    private final String c_not_supperted = "Not supported";

    @Test
    @DisplayName("Корректное заполнение исключения")
    void shouldThrowException() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            throw new QuestionsFileLoadingException(c_not_supperted);
        });
        assertEquals(c_not_supperted, exception.getMessage());
    }
}