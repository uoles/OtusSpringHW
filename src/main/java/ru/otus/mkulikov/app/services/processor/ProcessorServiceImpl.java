package ru.otus.mkulikov.app.services.processor;

import org.springframework.stereotype.Service;
import ru.otus.mkulikov.app.services.questions.QuestionsService;
import ru.otus.mkulikov.app.services.registration.RegistrationService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

@Service
public class ProcessorServiceImpl implements ProcessorService {

    private final QuestionsService questionsService;
    private final RegistrationService registration;

    public ProcessorServiceImpl(QuestionsService questionsService, RegistrationService registration) {
        this.questionsService = questionsService;
        this.registration = registration;
    }

    @Override
    public boolean registry(String userName, String userSurname) {
        return registration.addNewUser(userName, userSurname);
    }

    @Override
    public void startTest() {
        questionsService.showQuestions();
    }
}
