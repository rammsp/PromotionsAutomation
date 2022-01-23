package com.popcorn.promotions.requestspec;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class PromotionSpecifications {

    public RequestSpecification getGetPromotionSpecifications(String apikey) {
        RequestSpecification requestSpecification = RestAssured
                .given()
                .baseUri(System.getProperty("baseApiUri"))
                .pathParam("apikey", apikey);
        return requestSpecification;
    }
}
