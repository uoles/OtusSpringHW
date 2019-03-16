package ru.otus.mkulikov.processor;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

public interface Processor {

    void startTest() throws FileNotFoundException, URISyntaxException;
}
