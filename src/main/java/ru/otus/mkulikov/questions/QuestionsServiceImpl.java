package ru.otus.mkulikov.questions;

import ru.otus.mkulikov.console.ConsoleService;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.model.Question;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:41
 */

public class QuestionsServiceImpl implements QuestionsService {

    private final String c_delimeter = "---------------------------------------------------";
    private final String c_answerNumbers = "1234";
    private final String c_questionsFileName = "questions.csv";

    private QuestionsDAO questionsLoader;
    private ConsoleService consoleService;

    public QuestionsServiceImpl(QuestionsDAO questionsLoader, ConsoleService consoleService) {
        this.questionsLoader = questionsLoader;
        this.consoleService = consoleService;
    }

    @Override
    public void showQuestions() throws QuestionsFileLoadingException {
        getConsoleService().write(c_delimeter);
        List<Question> questions = getQuestionsLoader().getQuestions(c_questionsFileName);

        if (questions == null) {
            throw new QuestionsFileLoadingException("Список вопросов пуст!");
        }

        for (Question question : questions) {
            getConsoleService().write(question.getQuestion());
            getConsoleService().write(question.getAnswer1());
            getConsoleService().write(question.getAnswer2());
            getConsoleService().write(question.getAnswer3());
            getConsoleService().write(question.getAnswer4());

            String answer = null;
            boolean okAnswer = false;
            int i = 0;
            while (!okAnswer && i < 4) {
                System.out.println("Введите номер ответа: ");
                answer = getConsoleService().read();
                okAnswer = c_answerNumbers.contains(answer);
                i++;
            }

            question.setUserAnswer((!okAnswer && i == 4) ? "0" : answer);
            getConsoleService().write(c_delimeter);
        }

        long count = questions.stream()
                .filter(obj -> obj.getTrueAnswer().equals(obj.getUserAnswer()))
                .count();
        getConsoleService().write("Количество правильных ответов: " + count + " из " + questions.size());
        getConsoleService().write(c_delimeter);
    }

    public QuestionsDAO getQuestionsLoader() {
        return questionsLoader;
    }

    public ConsoleService getConsoleService() {
        return consoleService;
    }
}
