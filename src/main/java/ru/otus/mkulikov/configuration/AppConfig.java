package ru.otus.mkulikov.configuration;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAO;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAOImpl;
import ru.otus.mkulikov.services.console.ConsoleService;
import ru.otus.mkulikov.services.console.ConsoleServiceImpl;
import ru.otus.mkulikov.services.processor.ProcessorServiceImpl;
import ru.otus.mkulikov.services.questions.QuestionsService;
import ru.otus.mkulikov.services.questions.QuestionsServiceImpl;
import ru.otus.mkulikov.services.registration.RegistrationService;
import ru.otus.mkulikov.services.registration.RegistrationServiceImpl;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-19
 * Time: 14:15
 */

@Configuration
public class AppConfig {

    @Bean(destroyMethod = "destroy")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ConsoleServiceImpl consoleService() {
        return new ConsoleServiceImpl();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public RegistrationServiceImpl registrationService(ConsoleService consoleService) {
        return new RegistrationServiceImpl(consoleService);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public QuestionsDAOImpl questionsDAO() {
        return new QuestionsDAOImpl();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public QuestionsServiceImpl questionsService(QuestionsDAO questionsDAO, ConsoleService consoleService) {
        return new QuestionsServiceImpl(questionsDAO, consoleService);
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public ProcessorServiceImpl processorService(QuestionsService questionsService, RegistrationService registrationService) {
        return new ProcessorServiceImpl(questionsService, registrationService);
    }
}