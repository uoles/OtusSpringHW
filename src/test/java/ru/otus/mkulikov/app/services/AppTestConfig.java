package ru.otus.mkulikov.app.services;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by IntelliJ IDEA.
 * Developer: Maksim Kulikov
 * Date: 25.05.2019
 * Time: 16:51
 */

@SpringBootConfiguration
@ComponentScan(basePackages = "ru.otus.mkulikov.app")
@EnableConfigurationProperties
public class AppTestConfig {


}
