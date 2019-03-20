package ru.otus.mkulikov.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.mkulikov.models.Question;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-18
 * Time: 11:13
 */

@DisplayName("Класс Question")
class QuestionTest {

    private final String c_id = "1";
    private final String c_question = "Question";
    private final String c_userAnswer = "UserAnswer";
    private final String c_trueAnswer = "TrueAnswer";
    private final String c_answer1 = "Answer1";
    private final String c_answer2 = "Answer2";
    private final String c_answer3 = "Answer3";
    private final String c_answer4 = "Answer4";

    @Test
    @DisplayName("Корректное заполнение")
    public void fillQuestionTest() {
        Question question = new Question(
                c_id, c_question, c_answer1, c_answer2, c_answer3, c_answer4, c_trueAnswer, c_userAnswer
        );

        assertAll("question",
                () -> assertEquals(c_id, question.getId()),
                () -> assertEquals(c_question, question.getQuestion()),
                () -> assertEquals(c_userAnswer, question.getUserAnswer()),
                () -> assertEquals(c_trueAnswer, question.getTrueAnswer()),
                () -> assertEquals(c_answer1, question.getAnswer1()),
                () -> assertEquals(c_answer2, question.getAnswer2()),
                () -> assertEquals(c_answer3, question.getAnswer3()),
                () -> assertEquals(c_answer4, question.getAnswer4())
        );
    }
}