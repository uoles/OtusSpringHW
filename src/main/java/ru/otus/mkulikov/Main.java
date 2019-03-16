package ru.otus.mkulikov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.mkulikov.processor.Processor;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:27
 */

public class Main {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        try {
            Processor processor = (Processor) context.getBean("processor");
            processor.startTest();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
