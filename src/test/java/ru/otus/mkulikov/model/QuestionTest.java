package ru.otus.mkulikov.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    private Question question;

    @BeforeEach
    public void createModelQuestion() {
        question = new Question();
        question.setId(c_id);
        question.setQuestion(c_question);
        question.setUserAnswer(c_userAnswer);
        question.setTrueAnswer(c_trueAnswer);
        question.setAnswer1(c_answer1);
        question.setAnswer2(c_answer2);
        question.setAnswer3(c_answer3);
        question.setAnswer4(c_answer4);
    }

    @Test
    @DisplayName("Корректное заполнение id")
    public void fillIdTest() {
        assertEquals(c_id, question.getId());
    }

    @Test
    @DisplayName("Корректное заполнение question")
    public void fillQuestionTest() {
        assertEquals(c_question, question.getQuestion());
    }

    @Test
    @DisplayName("Корректное заполнение userAnswer")
    public void fillUserAnsweTest() {
        assertEquals(c_userAnswer, question.getUserAnswer());
    }

    @Test
    @DisplayName("Корректное заполнение trueAnswer")
    public void fillTrueAnsweTest() {
        assertEquals(c_trueAnswer, question.getTrueAnswer());
    }

    @Test
    @DisplayName("Корректное заполнение answer1")
    public void fillAnswer1AnsweTest() {
        assertEquals(c_answer1, question.getAnswer1());
    }

    @Test
    @DisplayName("Корректное заполнение answer2")
    public void fillAnswer2AnsweTest() {
        assertEquals(c_answer2, question.getAnswer2());
    }

    @Test
    @DisplayName("Корректное заполнение answer3")
    public void fillAnswer3AnsweTest() {
        assertEquals(c_answer3, question.getAnswer3());
    }

    @Test
    @DisplayName("Корректное заполнение answer4")
    public void fillAnswer4AnsweTest() {
        assertEquals(c_answer4, question.getAnswer4());
    }
}