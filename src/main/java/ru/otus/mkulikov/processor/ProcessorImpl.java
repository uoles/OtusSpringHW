package ru.otus.mkulikov.processor;

import ru.otus.mkulikov.questions.QuestionsProcess;
import ru.otus.mkulikov.questions.QuestionsLoader;
import ru.otus.mkulikov.registration.Registration;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

public class ProcessorImpl implements Processor {

    private QuestionsProcess questionsProcess;
    private Registration registration;

    public ProcessorImpl(QuestionsProcess questionsProcess, Registration registration) {
        this.questionsProcess = questionsProcess;
        this.registration = registration;
    }

    @Override
    public void startTest() throws FileNotFoundException, URISyntaxException {
        Scanner in = new Scanner(System.in);
        try {
            getRegistration().addNewUser(in);

            getQuestionsProcess().loadQuestions();
            getQuestionsProcess().showQuestions(in);
        } finally {
            in.close();
        }
    }

    public QuestionsProcess getQuestionsProcess() {
        return questionsProcess;
    }

    public Registration getRegistration() {
        return registration;
    }
}
