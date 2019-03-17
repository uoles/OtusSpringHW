package ru.otus.mkulikov;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.processor.ProcessorService;

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
            ProcessorService processor = context.getBean(ProcessorService.class);
            processor.startTest();
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
