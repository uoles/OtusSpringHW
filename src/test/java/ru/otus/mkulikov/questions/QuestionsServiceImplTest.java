package ru.otus.mkulikov.questions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.mkulikov.constants.StringConstants.c_error_load_consoleService;
import static ru.otus.mkulikov.constants.StringConstants.c_error_load_questionsDAO;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-18
 * Time: 12:00
 */

@DisplayName("Класс QuestionsServiceImpl")
class QuestionsServiceImplTest {

    private final QuestionsServiceImpl questionsService = new QuestionsServiceImpl(null, null);

    @Test
    @DisplayName("Корректный тип исключения для getQuestionsDAO")
    void getExceptionTypeQuestionsDAO() {
        assertThrows(QuestionsFileLoadingException.class, () -> {
            questionsService.getQuestionsDAO();
        });
    }

    @Test
    @DisplayName("Корректное исключение для getQuestionsDAO")
    void getExceptionQuestionsDAO() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            questionsService.getQuestionsDAO();
        });
        assertEquals(c_error_load_questionsDAO, exception.getMessage());
    }

    @Test
    @DisplayName("Корректный тип исключения для getConsoleService")
    void getExceptionTypeConsoleService() {
        assertThrows(QuestionsFileLoadingException.class, () -> {
            questionsService.getConsoleService();
        });
    }

    @Test
    @DisplayName("Корректное исключение для getConsoleService")
    void getExceptionConsoleService() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            questionsService.getConsoleService();
        });
        assertEquals(c_error_load_consoleService, exception.getMessage());
    }
}