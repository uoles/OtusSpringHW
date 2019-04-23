package ru.otus.mkulikov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.services.processor.ProcessorService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:27
 */

@SpringBootApplication
@EnableConfigurationProperties
public class Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Application.class);
        try {
            ProcessorService processor = context.getBean(ProcessorService.class);
            processor.startTest();
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        }
    }
}
