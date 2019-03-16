package ru.otus.mkulikov.questions;

import ru.otus.mkulikov.model.Question;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class QuestionsProcessImpl implements QuestionsProcess {

    private final String c_delimeter = "---------------------------------------------------";
    private final String c_answerNumbers = "1234";

    private QuestionsLoader questionsLoader;

    public QuestionsProcessImpl(QuestionsLoader questionsLoader) {
        this.questionsLoader = questionsLoader;
    }

    @Override
    public void loadQuestions() throws FileNotFoundException, URISyntaxException {
        getQuestionsLoader().loadFile();
    }

    @Override
    public void showQuestions(Scanner in) {
        System.out.println(c_delimeter);
        for (Question question : getQuestionsLoader().getQuestions()) {
            System.out.println(question.getQuestion());
            System.out.println(question.getAnswer1());
            System.out.println(question.getAnswer2());
            System.out.println(question.getAnswer3());
            System.out.println(question.getAnswer4());

            String answer = null;
            boolean okAnswer = false;
            int i = 0;
            while (!okAnswer && i < 4) {
                System.out.println("Введите номер ответа: ");
                answer = in.nextLine();
                okAnswer = c_answerNumbers.contains(answer);
                i++;
            }

            question.setUserAnswer((!okAnswer && i == 4) ? "0" : answer);
            System.out.println(c_delimeter);
        }

        long count = getQuestionsLoader().getQuestions().stream()
                .filter(obj -> obj.getTrueAnswer().equals(obj.getUserAnswer()))
                .count();
        System.out.println("Количество правильных ответов: " + count + " из " + getQuestionsLoader().getQuestions().size());
        System.out.println(c_delimeter);
    }

    public QuestionsLoader getQuestionsLoader() {
        return questionsLoader;
    }
}
