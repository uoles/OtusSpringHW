package ru.otus.mkulikov.app.services.localisation;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-21
 * Time: 14:02
 */

public interface LocalisationService {

    String getValue(String key);

    String getValueWithParams(String key, String[] params);
}
