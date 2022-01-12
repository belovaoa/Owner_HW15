package com.belovaoa.owner.HW.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:/Temp/token.properties",
        "classpath:token.properties"})
public interface ApiConfig extends Config {

    @Key("base.url")
    @DefaultValue("https://github.com")
    String baseUrl();

    @Key("token")
    String token();
}
