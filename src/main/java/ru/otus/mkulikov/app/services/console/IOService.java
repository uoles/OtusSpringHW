package ru.otus.mkulikov.app.services.console;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 17.03.2019
 * Time: 23:21
 */

public interface IOService {

    void write(String text);

    String read();
}
