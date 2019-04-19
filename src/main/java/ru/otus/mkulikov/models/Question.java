package ru.otus.mkulikov.models;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

@Data
public class Question implements Serializable {

    public static final String c_id = "id";
    private String id;

    public static final String c_question = "question";
    private String question;

    public static final String c_answer1 = "answer1";
    private String answer1;

    public static final String c_answer2 = "answer2";
    private String answer2;

    public static final String c_answer3 = "answer3";
    private String answer3;

    public static final String c_answer4 = "answer4";
    private String answer4;

    public static final String c_trueAnswer = "trueAnswer";
    private String trueAnswer;

    public static final String c_userAnswer = "userAnswer";
    private String userAnswer;

    public Question(String id, String question, String answer1, String answer2, String answer3, String answer4, String trueAnswer, String userAnswer) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.trueAnswer = trueAnswer;
        this.userAnswer = userAnswer;
    }

    public Question() {
    }
}
