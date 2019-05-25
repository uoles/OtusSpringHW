package ru.otus.mkulikov.app.models;

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

    private String id;
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String trueAnswer;
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
