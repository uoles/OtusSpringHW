package ru.otus.mkulikov.services.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.console.IOService;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAO;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:41
 */

@Service
public class QuestionsServiceImpl implements QuestionsService {

    private final String c_delimeter = "---------------------------------------------------";
    private final String c_answerNumbers = "1234";

    private final QuestionsDAO questionsDAO;
    private final IOService consoleService;

    @Autowired
    public QuestionsServiceImpl(QuestionsDAO questionsDAO, IOService consoleService) {
        this.questionsDAO = questionsDAO;
        this.consoleService = consoleService;
    }

    @Override
    public void showQuestions() throws QuestionsFileLoadingException {
        consoleService.write(c_delimeter);
        List<Question> questions = questionsDAO.getQuestions();

        if (questions == null) {
            throw new QuestionsFileLoadingException("Список вопросов пуст!");
        }

        for (Question question : questions) {
            consoleService.write(question.getQuestion());
            consoleService.write(question.getAnswer1());
            consoleService.write(question.getAnswer2());
            consoleService.write(question.getAnswer3());
            consoleService.write(question.getAnswer4());

            String answer = null;
            boolean okAnswer = false;
            int i = 0;
            while (!okAnswer && i < 4) {
                System.out.println("Введите номер ответа: ");
                answer = consoleService.read();
                okAnswer = c_answerNumbers.contains(answer);
                i++;
            }

            question.setUserAnswer((!okAnswer && i == 4) ? "0" : answer);
            consoleService.write(c_delimeter);
        }

        long count = questions.stream()
                .filter(obj -> obj.getTrueAnswer().equals(obj.getUserAnswer()))
                .count();
        consoleService.write("Количество правильных ответов: " + count + " из " + questions.size());
        consoleService.write(c_delimeter);
    }
}
