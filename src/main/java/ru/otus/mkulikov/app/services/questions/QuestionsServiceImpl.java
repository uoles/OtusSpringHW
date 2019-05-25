package ru.otus.mkulikov.app.services.questions;

import org.springframework.stereotype.Service;
import ru.otus.mkulikov.app.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.app.models.Question;
import ru.otus.mkulikov.app.services.console.IOService;
import ru.otus.mkulikov.app.services.localisation.LocalisationService;
import ru.otus.mkulikov.app.services.questions.dao.QuestionsDAO;

import java.util.Arrays;
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
    private final List<String> answerNumbers = Arrays.asList(new String[]{"1", "2", "3", "4"});

    private final QuestionsDAO questionsDAO;
    private final IOService consoleService;
    private final LocalisationService localisationService;

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
            boolean isOkAnswer = false;
            int i = 0;
            while (!isOkAnswer && i < 4) {
                consoleService.write(localisationService.getValue("enter.answer"));
                answer = consoleService.read();
                isOkAnswer = answerNumbers.contains(answer) && !answer.isEmpty();
                i++;
            }

            question.setUserAnswer((!isOkAnswer && i == 4) ? "0" : answer);
            consoleService.write(c_delimeter);
        }

        long count = questions.stream()
                .filter(obj -> obj.getTrueAnswer().equals(obj.getUserAnswer()))
                .count();

        consoleService.write(
                localisationService.getValueWithParams(
                        "count.true.answers",
                        new String[]{String.valueOf(count), String.valueOf(questions.size())}
                )
        );
        consoleService.write(c_delimeter);
    }
}
