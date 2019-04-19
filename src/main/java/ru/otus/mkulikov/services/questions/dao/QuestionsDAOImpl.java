package ru.otus.mkulikov.services.questions.dao;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.bean.ColumnPositionMappingStrategy;
import au.com.bytecode.opencsv.bean.CsvToBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.otus.mkulikov.config.QuetionsProperties;
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

    private final String c_file_encoding = "UTF-8";
    private final LocalisationService localisationService;
    private final String defaultFileDir;

    public QuestionsDAOImpl(LocalisationService localisationService, QuetionsProperties quetionsProperties) {
        this.localisationService = localisationService;
        this.defaultFileDir = quetionsProperties.getDir();
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @Override
    public List<Question> getQuestions() throws QuestionsFileLoadingException {
        String csvFilename = defaultFileDir + "/" + localisationService.getValue("csv.file.name");
        List<Question> questions;
        try {
            ClassPathResource resource = new ClassPathResource(csvFilename);
            CSVReader csvReader = new CSVReader(new InputStreamReader(resource.getInputStream(), c_file_encoding));
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
        strategy.setColumnMapping(new String[]{
                Question.c_id,
                Question.c_question,
                Question.c_answer1,
                Question.c_answer2,
                Question.c_answer3,
                Question.c_answer4,
                Question.c_trueAnswer
        });
        return strategy;
    }
}
