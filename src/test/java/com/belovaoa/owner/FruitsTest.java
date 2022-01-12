package com.belovaoa.owner;

import com.belovaoa.owner.config.FruitsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class FruitsTest {

    @Test
    public void testList() {
        System.setProperty("list", "orange,apple,banana");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsList())
                .contains("orange", "apple", "banana");
    }

    @Test
    public void testArray() {
        System.setProperty("array", "apple,orange,banana");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsArray())
                .contains("apple", "orange", "banana");
    }

    @Test
    public void testListWithDefault() {
        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsListWithDefault())
                .contains("orange", "apple");
    }

    @Test
    public void testListWithSeparator() {
        System.setProperty("list-with-separator", "orange;apple");

        FruitsConfig config = ConfigFactory.create(FruitsConfig.class, System.getProperties());
        assertThat(config.getFruitsListWithSeparator())
                .contains("orange", "apple");
    }
}
