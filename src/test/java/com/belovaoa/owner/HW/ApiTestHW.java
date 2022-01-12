package com.belovaoa.owner.HW;

import com.belovaoa.owner.HW.config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTestHW {

    @Test
    public void apiLocalFileTest() {

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com");
        assertThat(apiConfig.token()).isEqualTo("some_token");
    }

    @Test
    public void apiTempFileTest() throws Exception{
        String content = "token=another_token";
        Path properties = Paths.get("/Temp/token.properties");
        Files.write(properties, content.getBytes(StandardCharsets.UTF_8));

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.token()).isEqualTo("another_token");
        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com");

        Files.delete(properties);
    }
}
