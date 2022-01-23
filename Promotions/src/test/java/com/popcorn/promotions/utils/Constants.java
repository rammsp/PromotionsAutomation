package com.popcorn.promotions.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Constants {

    public final static String PATH_GET_PROMOTIONS = "/promotions?apikey={apikey}";

    public final static List<String> TRUE_FALSE = new ArrayList<>(Arrays.asList("true", "false"));

    public final static List<String> PROMOTION_PROGRAM_TYPES = new ArrayList<>(Arrays.asList("episode", "movie", "series", "season"));

    public final static String IMAGE_URL_REGEX_PATTERN = "^https://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*(.jpeg|.png)$";

    public final static String NUMBER_REGEX_PATTERN = "^[0-9]*$";

    public final static String PATH_TEST_DATA_YAML = "src/test/resources/testdata/TestData.yaml";

}
