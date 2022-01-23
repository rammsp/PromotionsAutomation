package com.popcorn.promotions.stepdefinitions;

import com.popcorn.promotions.requestspec.PromotionSpecifications;
import com.popcorn.promotions.responses.Error;
import com.popcorn.promotions.responses.PromotionDetails;
import com.popcorn.promotions.responses.Promotions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.HashMap;

import static com.popcorn.promotions.utils.Constants.*;
import static com.popcorn.promotions.utils.YAMLReader.getTestData;

public class PromotionsStepDefinition {

    public static Promotions promotions;
    public static Response promotionGetResponse;
    public static Error error;
    public static String apiKey;

    PromotionSpecifications promotionSpecifications = new PromotionSpecifications();

    @Given("I have a valid API key")
    public void iHaveAValidAPIKey() {
        apiKey = getTestData("VALID_API_KEY");
    }

    @When("I access promotions endpoint")
    public void iAccessPromotionsEndpoint() {
        RequestSpecification getPromotionSpecification = promotionSpecifications.getGetPromotionSpecifications(apiKey);
        promotionGetResponse = getPromotionSpecification.get(PATH_GET_PROMOTIONS);
    }

    @Then("HTTP Status code {int} should be provided to the user")
    public void httpStatusCodeShouldBeProvidedToTheUser(int statusCode) {
        Assert.assertEquals("Status code " + statusCode + " should be provided to the user", statusCode, promotionGetResponse.getStatusCode());
        if (promotionGetResponse.getStatusCode() == 200) {
            promotions = promotionGetResponse.as(Promotions.class);
        } else if (promotionGetResponse.getStatusCode() == 403) {
            error = promotionGetResponse.as(Error.class);;
        }
    }

    @And("Promotions details should be displayed to the user")
    public void promotionsDetailsShouldBeDisplayedToTheUser() {
        Assert.assertNotNull("Promotions details should be displayed to the user", promotions.getPromotions());
    }

    @And("All promotions should have a PromotionId associated with string value")
    public void allPromotionsShouldHaveAPromotionIdAssociatedWithStringValue() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            //Below assertion will assert both not null and string value, as the parsing Promotion Details Java Object has Data Type String for promotionId
            Assert.assertNotNull("All promotions should have a PromotionId", promotionDetails.getPromotionId());
        }
    }

    @And("All promotions should have a OrderId associated")
    public void allPromotionsShouldHaveAOrderIdAssociated() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertNotNull("All promotions should have a OrderId associated", promotionDetails.getOrderId());
        }
    }

    @And("All promotions should have a PromoArea associated")
    public void allPromotionsShouldHaveAPromoAreaAssociated() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertNotNull("All promotions should have a PromoArea associated", promotionDetails.getPromoArea());
        }
    }

    @And("All promotions should have a PromoType associated")
    public void allPromotionsShouldHaveAPromoTypeAssociated() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertNotNull("All promotions should have a PromoType associated", promotionDetails.getPromoType());
        }
    }

    @And("All ShowPrice should be either true or false")
    public void allShowPriceShouldBeEitherTrueOrFalse() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertTrue("All ShowPrice should be either true or false", TRUE_FALSE.contains(promotionDetails.getShowPrice()));
        }
    }

    @And("All ShowText should be either true or false")
    public void allShowTextShouldBeEitherTrueOrFalse() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertTrue("All ShowText should be either true or false", TRUE_FALSE.contains(promotionDetails.getShowText()));
        }
    }

    @And("All promotions should have LocalizedTexts associated")
    public void allPromotionsShouldHaveLocalizedTextsAssociated() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertNotNull("All promotions should have a LocalizedTexts associated", promotionDetails.getLocalizedTexts());
        }
    }

    @And("All LocalizedTexts should have ar and en values associated")
    public void allLocalizedTextsShouldHaveArAndEnValuesAssociated() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            Assert.assertTrue("All LocalizedTexts should have ar value associated", promotionDetails.getLocalizedTexts().containsKey("ar"));
            Assert.assertTrue("All LocalizedTexts should have en value associated", promotionDetails.getLocalizedTexts().containsKey("en"));
        }
    }

    @And("All ProgramType should be either episode or movie or series or season")
    public void allProgramTypeShouldBeEitherEpisodeOrMovieOrSeriesOrSeason() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            for (HashMap<String, Object> properties : promotionDetails.getProperties()) {
                if (properties.containsKey("programType")) {
                    Assert.assertTrue("All ProgramType should be either episode or movie or series or season", PROMOTION_PROGRAM_TYPES.contains(String.valueOf(properties.get("programType"))));
                }
            }
        }
    }

    @And("All image url should be in https url and jpeg or png format")
    public void allImageUrlShouldBeInHttpsUrlAndJpegOrPngFormat() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            if (promotionDetails.getImages() != null) {
                for (HashMap<String, Object> images : promotionDetails.getImages()) {
                    Assert.assertTrue("All image url should be in https url format", String.valueOf(images.get("url")).matches(IMAGE_URL_REGEX_PATTERN));
                }
            }
        }
    }

    @And("All image width should be in valid integer format")
    public void allImageWidthShouldBeInValidIntegerFormat() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            if (promotionDetails.getImages() != null) {
                for (HashMap<String, Object> images : promotionDetails.getImages()) {
                    Assert.assertTrue("All image width should be in valid integer format", String.valueOf(images.get("width")).matches(NUMBER_REGEX_PATTERN));
                }
            }
        }
    }

    @And("All image height should be in valid integer format")
    public void allImageHeightShouldBeInValidIntegerFormat() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            if (promotionDetails.getImages() != null) {
                for (HashMap<String, Object> images : promotionDetails.getImages()) {
                    Assert.assertTrue("All image height should be in valid integer format", String.valueOf(images.get("height")).matches(NUMBER_REGEX_PATTERN));
                }
            }
        }
    }

    @And("All image url should be in https width x height format")
    public void allImageUrlShouldBeInHttpsWidthXHeightFormat() {
        for (PromotionDetails promotionDetails : promotions.getPromotions()) {
            if (promotionDetails.getImages() != null) {
                for (HashMap<String, Object> images : promotionDetails.getImages()) {
                    Assert.assertEquals("All image height should be in valid integer format", String.valueOf(images.get("width")) + "x" + String.valueOf(images.get("height")), String.valueOf(images.get("id")));
                }
            }
        }
    }

    @Given("I have a invalid API key")
    public void iHaveAInvalidAPIKey() {
        apiKey = getTestData("INVALID_API_KEY");
    }

    @And("Error details should be displayed to the user")
    public void errorDetailsShouldBeDisplayedToTheUser() {
        Assert.assertNotNull("Error details should be displayed to the user", error.getError());
    }

    @And("Error should have a RequestId that is not null")
    public void errorShouldHaveARequestIdThatIsNotNull() {
        Assert.assertNotNull("Error should have a RequestId that is not null", error.getError().getRequestId());
        Assert.assertTrue("Error should have a RequestId that is not empty", error.getError().getRequestId().length() > 0);
    }

    @And("Error should have a {string} to be {string}")
    public void errorShouldHaveAToBe(String key, String value) {
        if (key.equals("code")) {
            Assert.assertTrue("Error should have a " + key + " to be " + value, error.getError().getCode().equals(value));
        } else if (key.equals("message")) {
            Assert.assertTrue("Error should have a " + key + " to be " + value, error.getError().getMessage().equals(value));
        }
    }

}
