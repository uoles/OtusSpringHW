package ru.otus.mkulikov.questions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAO;
import ru.otus.mkulikov.services.questions.dao.QuestionsDAOImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Класс QuestionsDAO")
class QuestionsDAOTest {

    private final QuestionsDAO questionsDAO = new QuestionsDAOImpl();

    private final String c_questionsFileName = "test_questions.csv";
    private final String c_questionsBadFileName = "test.csv";

    private final String c_test1 = "Тест1";
    private final String c_test2 = "Тест2";
    private final String c_test3 = "Тест3";

    @Test
    @DisplayName("Корректная загрузка вопросов")
    public void loadQuestionsTest() {
        try {
            List<Question> questions = questionsDAO.getQuestions(c_questionsFileName);

            assertAll("questions",
                    () -> assertNotNull(questions),
                    () -> assertEquals(3, questions.size()),
                    () -> assertEquals(c_test1, questions.get(0).getQuestion()),
                    () -> assertEquals(c_test2, questions.get(1).getQuestion()),
                    () -> assertEquals(c_test3, questions.get(2).getQuestion())
            );
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Корректное исключение на null")
    public void loadNullExceptionQuestionsTest() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            questionsDAO.getQuestions(null);
        });
        assertEquals("Имя файла не может быть null!", exception.getMessage());
    }

    @Test
    @DisplayName("Корректное исключение на неверное имя файла")
    public void loadExceptionQuestionsTest() {
        Throwable exception = assertThrows(QuestionsFileLoadingException.class, () -> {
            questionsDAO.getQuestions(c_questionsBadFileName);
        });
        assertEquals(String.format("Ошибка загрузки ресурса с именем %s!", c_questionsBadFileName), exception.getMessage());
    }
}