package ru.otus.mkulikov.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 19.04.2019
 * Time: 10:25
 */

@Data
@Component
@ConfigurationProperties(prefix = "questions.default")
public class QuetionsProperties {

    private String dir;
}
