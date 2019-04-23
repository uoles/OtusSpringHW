package ru.otus.mkulikov.services.registration;

import org.springframework.stereotype.Service;
import ru.otus.mkulikov.models.User;
import ru.otus.mkulikov.services.console.IOService;
import ru.otus.mkulikov.services.localisation.LocalisationService;

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

        User user = new User(name, surname);
        consoleService.write(
                localisationService.getValueWithParams("hello.user", new String[] {user.getName(), user.getSurname()})
        );
    }
}
