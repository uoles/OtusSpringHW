package ru.otus.mkulikov.questions;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
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

public class QuestionsDAOImpl implements QuestionsDAO {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public List<Question> loadFile(String csvFilename) throws QuestionsFileLoadingException {
        List<Question> questions = null;
        try {
            CsvToBean csv = new CsvToBean();
            File file = new File(getClass().getResource("/" + csvFilename).toURI());

            CSVReader csvReader = new CSVReader(new FileReader(file));
            questions = csv.parse(setColumMapping(), csvReader);
        } catch (FileNotFoundException e) {
            throw new QuestionsFileLoadingException("Файл с именем " + csvFilename + " не найден!", e);
        } catch (URISyntaxException e) {
            throw new QuestionsFileLoadingException("Ошибка чтения файла!", e);
        }
        return questions;
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
    public List<Question> getQuestions(String csvFilename) throws QuestionsFileLoadingException {
        return loadFile(csvFilename);
    }
}
