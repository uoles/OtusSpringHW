package ru.otus.mkulikov.services.questions.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.springframework.stereotype.Repository;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.localisation.LocalisationService;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-14
 * Time: 16:42
 */

@Repository
public class QuestionsDAOImpl implements QuestionsDAO {

    private final LocalisationService localisationService;

    public QuestionsDAOImpl(LocalisationService localisationService) {
        this.localisationService = localisationService;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List<Question> getQuestions() throws QuestionsFileLoadingException {
        String csvFilename = localisationService.getValue("csv.file.name");

        if (csvFilename == null) {
            throw new QuestionsFileLoadingException(localisationService.getValue("questions.load.null.filename"));
        }

        List<Question> questions = new ArrayList<Question>();
        try {
            URL url = getClass().getResource("/" + csvFilename);
            if (url == null) {
                throw new QuestionsFileLoadingException(
                        localisationService.getValueWithParams("questions.load.error.filename", new String[] {csvFilename})
                );
            }

            File file = new File(url.toURI());
            CSVReader csvReader=new CSVReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            CsvToBean csv = new CsvToBean();

            questions = csv.parse(setColumMapping(), csvReader);
        } catch (FileNotFoundException e) {
            throw new QuestionsFileLoadingException(localisationService.getValueWithParams("questions.find.error.filename", new String[] {csvFilename}), e);
        } catch (URISyntaxException e) {
            throw new QuestionsFileLoadingException(localisationService.getValue("questions.read.error"), e);
        } catch (UnsupportedEncodingException e) {
            throw new QuestionsFileLoadingException(localisationService.getValue("questions.encoding.error"), e);
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
}
