package com.belovaoa.owner.HW;

import com.belovaoa.owner.HW.config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTestHW {

    @Test
    public void weblocaleTest() {
        System.setProperty("environment", "locale");

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowserName()).isEqualTo("CHROME");
        assertThat(webConfig.getBrowserVersion()).isEqualTo("96.0");
    }

    @Test
    public void webRemoteTest() {
        System.setProperty("environment", "remote");

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowserName()).isEqualTo("CHROME");
        assertThat(webConfig.getBrowserVersion()).isEqualTo("96.0");
        assertThat(webConfig.remoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}
