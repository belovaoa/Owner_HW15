package com.belovaoa.owner.config;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class WebDriverConfig {

    public URL getRemoteUrl() {
        String remoteUrl = System.getProperty("remoteUrl");
        if (Objects.nonNull(remoteUrl)) {
            try {
                return new URL(remoteUrl);
            } catch (MalformedURLException e) {
                throw  new RuntimeException("Bad url");
            }
        }
        return null;
    }

    public Browser getBrowser() {
        String browserString = System.getProperty("browser");
        // Добавим дефолтные значения:
        if (Objects.isNull(browserString)) {
           return Browser.CHROME;
        }
        return Browser.valueOf(browserString);
        // или в терминале добавим к ./gradlew test --tests WebDriverTest -Dbrowser=FIREFOX (или другое имя браузера)
        // return Browser.CHROME;
    }

    public String getBaseUrl() {
        String baseUrlString = System.getProperty("baseUrl");
        // Добавим дефолтные значения:
        if (Objects.isNull(baseUrlString)) {
            return "https://github.com";
        }
        return baseUrlString;
        // или в терминале добавим к  ./gradlew test --tests WebDriverTest -DbaseUrl=... (url)
        // return "https://github.com/";
    }
}
