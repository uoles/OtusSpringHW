package ru.otus.mkulikov.shell;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import ru.otus.mkulikov.app.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.app.services.processor.ProcessorService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 25.05.2019
 * Time: 14:20
 */

@ShellComponent
public class Commands {

    private boolean isCheckIn = false;
    private ProcessorService processor;

    public Commands(ProcessorService processor) {
        this.processor = processor;
    }

    @ShellMethod(key = { "registry" }, value = "User registration")
    public void registry(String userName, String userSurname) {
        try {
            isCheckIn = processor.registry(userName, userSurname);
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        }
    }

    @ShellMethod(key = { "startTest" }, value = "Start test")
    @ShellMethodAvailability({"checkRegistry"})
    public void startTest() {
        try {
            processor.startTest();
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        }
    }

    public Availability checkRegistry() {
        String message = "you are not registered";
        return isCheckIn ? Availability.available() : Availability.unavailable(message);
    }
}
