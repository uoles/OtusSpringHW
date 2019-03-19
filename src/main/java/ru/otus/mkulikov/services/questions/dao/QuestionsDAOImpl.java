package ru.otus.mkulikov.services.questions.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.springframework.stereotype.Repository;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:42
 */

@Repository
public class QuestionsDAOImpl implements QuestionsDAO {

    @SuppressWarnings({"rawtypes", "unchecked"})
    private List<Question> loadFile(String csvFilename) throws QuestionsFileLoadingException {
        if (csvFilename == null) {
            throw new QuestionsFileLoadingException("Имя файла не может быть null!");
        }

        List<Question> questions = null;
        try {
            URL url = getClass().getResource("/" + csvFilename);
            if (url == null) {
                throw new QuestionsFileLoadingException(
                        String.format("Ошибка загрузки ресурса с именем %s!", csvFilename)
                );
            }

            File file = new File(url.toURI());
            CSVReader csvReader=new CSVReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            CsvToBean csv = new CsvToBean();

            questions = csv.parse(setColumMapping(), csvReader);
        } catch (FileNotFoundException e) {
            throw new QuestionsFileLoadingException("Файл с именем " + csvFilename + " не найден!", e);
        } catch (URISyntaxException e) {
            throw new QuestionsFileLoadingException("Ошибка чтения файла!", e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
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
