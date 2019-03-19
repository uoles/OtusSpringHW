package ru.otus.mkulikov.processor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.services.processor.ProcessorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.mkulikov.constants.StringConstants.c_error_load_questionsService;
import static ru.otus.mkulikov.constants.StringConstants.c_error_load_registrationService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-18
 * Time: 11:37
 */

@DisplayName("Класс ProcessorServiceImpl")
class ProcessorServiceImplTest {

    private final ProcessorServiceImpl processorServiceNull = new ProcessorServiceImpl(null, null);

    @Test
    @DisplayName("Корректный тип исключения для getQuestionsProcess")
    void getExceptionTypeQuestionsProcessTest() {
        assertThrows(QuestionsFileLoadingException.class, () -> {
            processorServiceNull.getQuestionsService();
        });
    }

    @Test
    @DisplayName("Корректное исключение для getQuestionsProcess")
    void getExceptionQuestionsProcessTest() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            processorServiceNull.getQuestionsService();
        });
        assertEquals(c_error_load_questionsService, exception.getMessage());
    }

    @Test
    @DisplayName("Корректный тип исключения для getRegistrationTest")
    void getExceptionTypeRegistrationTest() {
        assertThrows(QuestionsFileLoadingException.class, () -> {
            processorServiceNull.getRegistration();
        });
    }

    @Test
    @DisplayName("Корректное исключение для getRegistrationTest")
    void getExceptionRegistrationTest() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            processorServiceNull.getRegistration();
        });
        assertEquals(c_error_load_registrationService, exception.getMessage());
    }
}