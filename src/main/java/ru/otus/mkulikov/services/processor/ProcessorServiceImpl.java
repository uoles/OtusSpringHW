package ru.otus.mkulikov.services.processor;

import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.services.questions.QuestionsService;
import ru.otus.mkulikov.services.registration.RegistrationService;

import static ru.otus.mkulikov.constants.StringConstants.c_error_load_questionsService;
import static ru.otus.mkulikov.constants.StringConstants.c_error_load_registrationService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

public class ProcessorServiceImpl implements ProcessorService {

    private QuestionsService questionsService;
    private RegistrationService registration;

    public ProcessorServiceImpl(QuestionsService questionsService, RegistrationService registration) {
        this.questionsService = questionsService;
        this.registration = registration;
    }

    @Override
    public void startTest() throws QuestionsFileLoadingException {
        getRegistration().addNewUser();
        getQuestionsService().showQuestions();
    }

    public QuestionsService getQuestionsService() throws QuestionsFileLoadingException {
        if (questionsService == null) {
            throw new QuestionsFileLoadingException(c_error_load_questionsService);
        }
        return questionsService;
    }

    public RegistrationService getRegistration() throws QuestionsFileLoadingException {
        if (registration == null) {
            throw new QuestionsFileLoadingException(c_error_load_registrationService);
        }
        return registration;
    }
}
