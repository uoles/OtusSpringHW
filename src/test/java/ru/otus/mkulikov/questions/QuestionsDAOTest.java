package ru.otus.mkulikov.questions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.localisation.LocalisationServiceImpl;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAO;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAOImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-22
 * Time: 13:58
 */

@DisplayName("Класс QuestionsDAO")
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/test.properties")
class QuestionsDAOTest {

    @Value("${test.basename}")
    private String folder;
    @Value("${test.default.encoding}")
    private String encoding;
    @Value("${test.default.ru}")
    private String ru;
    @Value("${test.default.en}")
    private String en;
    @Value("${test.question.folder}")
    private String questionFolder;

    private final String c_test1 = "Тест1";
    private final String c_test2 = "Тест2";
    private final String c_test3 = "Тест3";

    @Test
    @DisplayName("Корректная загрузка вопросов")
    public void loadQuestionsTest() throws QuestionsFileLoadingException {
        LocalisationServiceImpl localisationService = new LocalisationServiceImpl(folder, encoding, ru);
        QuestionsDAO questionsDAO = new QuestionsDAOImpl(localisationService, questionFolder);

        List<Question> questions = questionsDAO.getQuestions();

        assertAll("questions",
                () -> assertNotNull(questions),
                () -> assertEquals(3, questions.size()),
                () -> assertEquals(c_test1, questions.get(0).getQuestion()),
                () -> assertEquals(c_test2, questions.get(1).getQuestion()),
                () -> assertEquals(c_test3, questions.get(2).getQuestion())
        );
    }
}