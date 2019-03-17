package ru.otus.mkulikov.processor;

import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.questions.QuestionsService;
import ru.otus.mkulikov.registration.RegistrationService;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

public class ProcessorServiceImpl implements ProcessorService {

    private QuestionsService questionsProcess;
    private RegistrationService registration;

    public ProcessorServiceImpl(QuestionsService questionsProcess, RegistrationService registration) {
        this.questionsProcess = questionsProcess;
        this.registration = registration;
    }

    @Override
    public void startTest() throws QuestionsFileLoadingException {
        getRegistration().addNewUser();
        getQuestionsProcess().showQuestions();
    }

    public QuestionsService getQuestionsProcess() {
        return questionsProcess;
    }

    public RegistrationService getRegistration() {
        return registration;
    }
}
