package ru.otus.mkulikov.shell;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.services.processor.ProcessorService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 25.05.2019
 * Time: 14:20
 */

@ShellComponent
public class Commands {

    private ProcessorService processor;

    public Commands(ProcessorService processor) {
        this.processor = processor;
    }

    @ShellMethod(key = { "startTest" }, value = "Start test")
    public void startTest() {
        try {
            processor.startTest();
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        }
    }
}
