package ru.otus.mkulikov.services.questions.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.mkulikov.exceptions.QuestionsFileLoadingException;
import ru.otus.mkulikov.models.Question;
import ru.otus.mkulikov.services.localisation.LocalisationService;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
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
    private final String defaultFileDir;

    public QuestionsDAOImpl(
            LocalisationService localisationService,
            @Value("${questions.default.dir}") String defaultFileDir
    ) {
        this.localisationService = localisationService;
        this.defaultFileDir = defaultFileDir;
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List<Question> getQuestions() throws QuestionsFileLoadingException {
        String csvFilename = defaultFileDir + "/" + localisationService.getValue("csv.file.name");
        List<Question> questions;
        try {
            ClassPathResource resource = new ClassPathResource(csvFilename);
            CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream(), "UTF-8"));
            questions = new CsvToBean().parse(setColumMapping(), csvReader);
        } catch (FileNotFoundException e) {
            throw new QuestionsFileLoadingException(localisationService.getValueWithParams("questions.find.error.filename", new String[] {csvFilename}), e);
        } catch (UnsupportedEncodingException e) {
            throw new QuestionsFileLoadingException(localisationService.getValue("questions.encoding.error"), e);
        } catch (IOException e) {
            throw new QuestionsFileLoadingException(localisationService.getValue("questions.io.error"), e);
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
