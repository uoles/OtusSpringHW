package ru.otus.mkulikov.services.console;

import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 17.03.2019
 * Time: 23:21
 */

@Service
public class ConsoleServiceImpl implements ConsoleService {

    private final Scanner in;

    public ConsoleServiceImpl() {
        in = new Scanner(System.in);
    }

    @Override
    public void write(String text) {
        System.out.println(text);
    }

    @Override
    public String read() {
        return in.nextLine();
    }

    @PreDestroy
    public void destroy() {
        in.close();
    }
}
