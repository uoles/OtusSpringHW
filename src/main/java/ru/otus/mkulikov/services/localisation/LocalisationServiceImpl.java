package ru.otus.mkulikov.services.localisation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 2019-03-21
 * Time: 14:02
 */

@Service
public class LocalisationServiceImpl extends ReloadableResourceBundleMessageSource implements LocalisationService {

    private final Locale locale;
    private final Locale russian = new Locale("ru");

    public LocalisationServiceImpl(
            @Value("${locale.basename}") String basename,
            @Value("${locale.default.encoding}") String defaultEncoding,
            @Value("${locale.default}") String localeDefault
    ) {
        super();
        setBasename(basename);
        setDefaultEncoding(defaultEncoding);

        locale = (localeDefault != null)
                ? new Locale(localeDefault)
                : russian;
    }

    public String getValue(String key) {
        return getMessage(key, null, locale);
    }

    public String getValueWithParams(String key, String[] params) {
        return getMessage(key, params, locale);
    }
}
