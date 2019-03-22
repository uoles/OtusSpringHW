package ru.otus.mkulikov.services.questions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.console.IOService;
import ru.otus.mkulikov.services.localisation.LocalisationService;
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
    private final LocalisationService localisationService;

    @Autowired
    public QuestionsServiceImpl(QuestionsDAO questionsDAO, IOService consoleService, LocalisationService localisationService) {
        this.questionsDAO = questionsDAO;
        this.consoleService = consoleService;
        this.localisationService = localisationService;
    }

    @Override
    public void showQuestions() throws QuestionsFileLoadingException {
        consoleService.write(c_delimeter);
        List<Question> questions = questionsDAO.getQuestions();

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
                consoleService.write(localisationService.getValue("enter.answer"));
                answer = consoleService.read();
                okAnswer = c_answerNumbers.contains(answer) && !answer.isEmpty();
                i++;
            }

            question.setUserAnswer((!okAnswer && i == 4) ? "0" : answer);
            consoleService.write(c_delimeter);
        }

        long count = questions.stream()
                .filter(obj -> obj.getTrueAnswer().equals(obj.getUserAnswer()))
                .count();

        consoleService.write(
                localisationService.getValueWithParams(
                        "count.true.answers",
                        new String[] {String.valueOf(count), String.valueOf(questions.size())}
                )
        );
        consoleService.write(c_delimeter);
    }
}
