package ru.otus.mkulikov.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.models.User;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-18
 * Time: 10:57
 */

@DisplayName("Класс User")
class UserTest {

    private final String c_userName = "Name";
    private final String c_userSurname = "Surname";

    @Test
    @DisplayName("Корректное создание")
    public void createUserTest() {
        User user = new User(c_userName, c_userSurname);
        assertAll("user",
                () -> assertEquals(c_userName, user.getName()),
                () -> assertEquals(c_userSurname, user.getSurname())
        );

        Assertions.assertThat(user).hasFieldOrPropertyWithValue("name", c_userName);
    }
}