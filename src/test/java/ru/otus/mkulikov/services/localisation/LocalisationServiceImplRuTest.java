package ru.otus.mkulikov.services.localisation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.mkulikov.config.LocaleProperties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-22
 * Time: 13:58
 */

@DisplayName("Класс LocalisationServiceImpl")
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("ru")
class LocalisationServiceImplRuTest {

    @Autowired
    private LocaleProperties localeProperties;

    @Test
    @DisplayName("Проверка получения значения ru локали")
    void getValueRuTest() {
        LocalisationService ruLocale = new LocalisationServiceImpl(localeProperties);
        String value = ruLocale.getValue("test.key");

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("тест123", value)
        );
    }

    @Test
    @DisplayName("Проверка получения значения ru локали с параметром")
    void getValueRuWithParamsTest() {
        LocalisationService ruLocale = new LocalisationServiceImpl(localeProperties);
        String value = ruLocale.getValueWithParams("test.key.params", new String[]{"При", "вет"});

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("При и вет - Привет", value)
        );
    }
}