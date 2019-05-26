package ru.otus.mkulikov.app.services.registration;

import org.springframework.stereotype.Service;
import ru.otus.mkulikov.app.models.User;
import ru.otus.mkulikov.app.services.console.IOService;
import ru.otus.mkulikov.app.services.localisation.LocalisationService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:34
 */

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final IOService consoleService;
    private final LocalisationService localisationService;

    public RegistrationServiceImpl(IOService consoleService, LocalisationService localisationService) {
        this.consoleService = consoleService;
        this.localisationService = localisationService;
    }

    @Override
    public void addNewUser() {
        consoleService.write(localisationService.getValue("enter.your.data"));
        consoleService.write(localisationService.getValue("enter.your.surname"));
        String surname = consoleService.read();

        consoleService.write(localisationService.getValue("enter.your.name"));
        String name = consoleService.read();

        checkUser(new User(name, surname));
    }

    @Override
    public boolean addNewUser(String userName, String userSurname) {
        return checkUser(new User(userName, userSurname));
    }

    private boolean checkUser(User user) {
        String name = user.getName().replace(" ", "");
        String surname = user.getSurname().replace(" ", "");

        if (name != null && !name.isEmpty() && surname != null && !surname.isEmpty()) {
            greetingUser(new User(name, surname));
            return true;
        } else {
            wrongUser();
            return false;
        }
    }

    private void wrongUser() {
        consoleService.write(
                localisationService.getValue("hello.user.fail")
        );
    }

    private void greetingUser(User user) {
        consoleService.write(
                localisationService.getValueWithParams("hello.user", new String[] {user.getName(), user.getSurname()})
        );
    }
}
