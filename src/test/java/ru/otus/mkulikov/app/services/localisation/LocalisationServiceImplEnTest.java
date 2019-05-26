package ru.otus.mkulikov.app.services.localisation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.mkulikov.app.services.AppTestConfig;
import ru.otus.mkulikov.app.config.LocaleProperties;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-22
 * Time: 13:58
 */

@DisplayName("Класс LocalisationServiceImpl")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AppTestConfig.class)
@ActiveProfiles("en")
class LocalisationServiceImplEnTest {

    @Autowired
    private LocaleProperties localeProperties;

    @Test
    @DisplayName("Проверка получения значения en локали")
    void getValueEnTest() {
        LocalisationService enLocale = new LocalisationServiceImpl(localeProperties);
        String value = enLocale.getValue("test.key");

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("test123", value)
        );
    }

    @Test
    @DisplayName("Проверка получения значения en локали с параметром")
    void getValueEnWithParamsTest() {
        LocalisationService enLocale = new LocalisationServiceImpl(localeProperties);
        String value = enLocale.getValueWithParams("test.key.params", new String[]{"Hel", "lo"});

        assertAll("value",
                () -> assertNotNull(value),
                () -> assertEquals("Hel & lo - Hello", value)
        );
    }
}