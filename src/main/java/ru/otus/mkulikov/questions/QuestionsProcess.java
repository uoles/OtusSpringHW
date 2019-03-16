package ru.otus.mkulikov.questions;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public interface QuestionsProcess {

    void loadQuestions() throws FileNotFoundException, URISyntaxException;

    void showQuestions(Scanner in);
}
