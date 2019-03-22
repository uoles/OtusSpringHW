package ru.otus.mkulikov.services.localisation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.otus.mkulikov.Application;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-22
 * Time: 13:58
 */

@DisplayName("Класс LocalisationServiceImpl")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Application.class)
@TestPropertySource("/test.properties")
class LocalisationServiceImplTest {

    @Value("${test.basename}")
    private String folder;
    @Value("${test.default.encoding}")
    private String encoding;
    @Value("${test.default.ru}")
    private String ru;
    @Value("${test.default.en}")
    private String en;

    @Test
    @DisplayName("Проверка получения значения ru локали")
    void getValueRuTest() {
        LocalisationService ruLocale = new LocalisationServiceImpl(folder, encoding, ru);
        String value = ruLocale.getValue("test.key");

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("тест123", value)
        );
    }

    @Test
    @DisplayName("Проверка получения значения en локали")
    void getValueEnTest() {
        LocalisationService enLocale = new LocalisationServiceImpl(folder, encoding, en);
        String value = enLocale.getValue("test.key");

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("test123", value)
        );
    }

    @Test
    @DisplayName("Проверка получения значения ru локали с параметром")
    void getValueRuWithParamsTest() {
        LocalisationService ruLocale = new LocalisationServiceImpl(folder, encoding, ru);
        String value = ruLocale.getValueWithParams("test.key.params", new String[]{"При", "вет"});

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("При и вет - Привет", value)
        );
    }

    @Test
    @DisplayName("Проверка получения значения en локали с параметром")
    void getValueEnWithParamsTest() {
        LocalisationService enLocale = new LocalisationServiceImpl(folder, encoding, en);
        String value = enLocale.getValueWithParams("test.key.params", new String[]{"Hel", "lo"});

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("Hel & lo - Hello", value)
        );
    }
}