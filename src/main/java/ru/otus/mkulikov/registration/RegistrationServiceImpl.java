package ru.otus.mkulikov.registration;

import ru.otus.mkulikov.console.ConsoleService;
import ru.otus.mkulikov.model.User;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

public class RegistrationServiceImpl implements RegistrationService {

    private User user;
    private ConsoleService consoleService;

    public RegistrationServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void addNewUser() {
        getConsoleService().write("Введите свои данные");
        getConsoleService().write("Фамилия: ");
        String surname = getConsoleService().read();

        getConsoleService().write("Имя: ");
        String name = getConsoleService().read();

        user = new User(name, surname);
        getConsoleService().write(String.format("Здравствуйте, %s %s!", surname, name));
    }

    public ConsoleService getConsoleService() {
        return consoleService;
    }
}
