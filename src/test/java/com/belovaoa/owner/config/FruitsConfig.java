package com.belovaoa.owner.config;

import org.aeonbits.owner.Config;

import java.util.List;

public interface FruitsConfig extends Config {

    @Key("array")
    String[] getFruitsArray();

    @Key("list")
    List<String> getFruitsList();

    @Key("list-with-default")
    @DefaultValue("orange,apple")
    List<String> getFruitsListWithDefault();

    @Separator(";")
    @Key("list-with-separator")
    @DefaultValue("orange;apple")
    List<String> getFruitsListWithSeparator();
}
