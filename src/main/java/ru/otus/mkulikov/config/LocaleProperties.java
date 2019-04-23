package ru.otus.mkulikov.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 19.04.2019
 * Time: 9:57
 */

@Data
@Component
@ConfigurationProperties(prefix = "locale")
public class LocaleProperties {

    private String basename;
    private String defaultLocale;
    private String encoding;
}
