package ru.otus.mkulikov;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.services.processor.ProcessorService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:27
 */

@Configuration
@ComponentScan
@PropertySource("classpath:config.properties")
public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
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
