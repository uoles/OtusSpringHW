package ru.otus.mkulikov.services.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mkulikov.models.User;
import ru.otus.mkulikov.services.console.IOService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final IOService consoleService;

    @Autowired
    public RegistrationServiceImpl(IOService consoleService) {
        this.consoleService = consoleService;
    }

    @Override
    public void addNewUser() {
        consoleService.write("Введите свои данные");
        consoleService.write("Фамилия: ");
        String surname = consoleService.read();

        consoleService.write("Имя: ");
        String name = consoleService.read();

        User user = new User(name, surname);
        consoleService.write(String.format("Здравствуйте, %s %s!", user.getSurname(), user.getName()));
    }
}
