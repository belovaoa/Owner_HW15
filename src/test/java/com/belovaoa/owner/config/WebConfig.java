package com.belovaoa.owner.config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")
public interface WebConfig extends Config {

    @Key("browser.name")
    @DefaultValue("CHROME")
    String getBrowserName();

    @Key("browser.version")
    @DefaultValue("96.0")
    String getBrowserVersion();

    @Key("selenoid.url")
    String remoteUrl();
}
