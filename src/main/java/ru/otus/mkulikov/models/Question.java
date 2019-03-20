package ru.otus.mkulikov.models;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 15:54
 */

public class Question implements Serializable {

    @Setter
    @Getter
    private String id;
    @Setter
    @Getter
    private String question;
    @Setter
    @Getter
    private String answer1;
    @Setter
    @Getter
    private String answer2;
    @Setter
    @Getter
    private String answer3;
    @Setter
    @Getter
    private String answer4;
    @Setter
    @Getter
    private String trueAnswer;
    @Setter
    @Getter
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
