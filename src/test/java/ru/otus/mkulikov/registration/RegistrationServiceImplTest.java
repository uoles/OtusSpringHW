package ru.otus.mkulikov.registration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.otus.mkulikov.constants.StringConstants.c_error_load_consoleService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-18
 * Time: 13:02
 */

@DisplayName("Класс RegistrationServiceImpl")
class RegistrationServiceImplTest {

    private final RegistrationServiceImpl registrationService = new RegistrationServiceImpl(null);

    @Test
    @DisplayName("Корректный тип исключения для getConsoleService")
    void getExceptionTypeConsoleServiceTest() {
        assertThrows(QuestionsFileLoadingException.class, () -> {
            registrationService.getConsoleService();
        });
    }

    @Test
    @DisplayName("Корректное исключение для getQuestionsDAO")
    void getExceptionConsoleServiceTest() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            registrationService.getConsoleService();
        });
        assertEquals(c_error_load_consoleService, exception.getMessage());
    }
}