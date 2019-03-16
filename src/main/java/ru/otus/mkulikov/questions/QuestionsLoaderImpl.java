package ru.otus.mkulikov.questions;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import ru.otus.mkulikov.model.Question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:42
 */

public class QuestionsLoaderImpl implements QuestionsLoader {

    private List<Question> questions;

    @Override
    @SuppressWarnings({"rawtypes", "unchecked"})
    public void loadFile() throws FileNotFoundException, URISyntaxException {
        CsvToBean csv = new CsvToBean();
        String csvFilename = "questions.csv";
        File file = new File(getClass().getResource("/" + csvFilename).toURI());

        CSVReader csvReader = new CSVReader(new FileReader(file));
        questions = csv.parse(setColumMapping(), csvReader);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    private ColumnPositionMappingStrategy setColumMapping() {
        ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Question.class);
        String[] columns = new String[]{"id", "question", "answer1", "answer2", "answer3", "answer4", "trueAnswer"};
        strategy.setColumnMapping(columns);
        return strategy;
    }

    @Override
    public List<Question> getQuestions() {
        return questions;
    }
}
