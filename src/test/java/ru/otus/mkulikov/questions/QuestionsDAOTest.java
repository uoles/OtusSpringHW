package ru.otus.mkulikov.questions;

import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.model.Question;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class QuestionsDAOTest {

    private final String c_questionsFileName = "questions.csv";

    @Test
    public void loadQuestionsTest() {
        try {
            QuestionsDAO questionsDAO = new QuestionsDAOImpl();
            List<Question> questions = questionsDAO.getQuestions(c_questionsFileName);

            assertNotNull(questions);
            assertEquals(questions.size(), 3);
            assertEquals(questions.get(0).getQuestion(), "Тест1");
            assertEquals(questions.get(1).getQuestion(), "Тест2");
            assertEquals(questions.get(2).getQuestion(), "Тест3");
        } catch (QuestionsFileLoadingException e) {
            e.printStackTrace();
        }
    }
}