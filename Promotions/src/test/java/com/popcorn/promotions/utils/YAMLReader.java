package com.popcorn.promotions.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;

import static com.popcorn.promotions.utils.Constants.*;

public class YAMLReader {

    public static String getTestData(String key) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File(PATH_TEST_DATA_YAML));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Yaml yaml = new Yaml();
        Map<String, Object> testDataMap = yaml.load(inputStream);
        return String.valueOf(testDataMap.get(key));
    }

}
