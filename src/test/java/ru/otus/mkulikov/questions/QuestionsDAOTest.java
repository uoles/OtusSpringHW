package ru.otus.mkulikov.questions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.localisation.LocalisationServiceImpl;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAO;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAOImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionsDAO")
class QuestionsDAOTest {

    private final LocalisationServiceImpl localisationService = new LocalisationServiceImpl("/i18n/bundle", "UTF-8", "ru");
    private final QuestionsDAO questionsDAO = new QuestionsDAOImpl(localisationService, "/questions");

    private final String c_test1 = "Тест1";
    private final String c_test2 = "Тест2";
    private final String c_test3 = "Тест3";

    @Test
    @DisplayName("Корректная загрузка вопросов")
    public void loadQuestionsTest() throws QuestionsFileLoadingException {
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