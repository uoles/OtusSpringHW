package ru.otus.mkulikov.registration;

import ru.otus.mkulikov.console.ConsoleService;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.model.User;

import static ru.otus.mkulikov.constants.StringConstants.c_error_load_consoleService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

public class RegistrationServiceImpl implements RegistrationService {

    private ConsoleService consoleService;

    public RegistrationServiceImpl(ConsoleService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void addNewUser() throws QuestionsFileLoadingException {
        getConsoleService().write("Введите свои данные");
        getConsoleService().write("Фамилия: ");
        String surname = getConsoleService().read();

        getConsoleService().write("Имя: ");
        String name = getConsoleService().read();

        User user = new User(name, surname);
        getConsoleService().write(String.format("Здравствуйте, %s %s!", user.getSurname(), user.getName()));
    }

    public ConsoleService getConsoleService() throws QuestionsFileLoadingException {
        if (consoleService == null) {
            throw new QuestionsFileLoadingException(c_error_load_consoleService);
        }
        return consoleService;
    }
}
