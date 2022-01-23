@promotions @api @smoke
Feature: Promotions
  As a customer
  I access promotions webservice
  To get promotions across multiple OTT providers

  Scenario: Get promotions using valid API key
    Given I have a valid API key
    When I access promotions endpoint
    Then HTTP Status code 200 should be provided to the user
    And Promotions details should be displayed to the user
    And All promotions should have a PromotionId associated with string value
    And All promotions should have a OrderId associated
    And All promotions should have a PromoArea associated
    And All promotions should have a PromoType associated
    And All ShowPrice should be either true or false
    And All ShowText should be either true or false
    And All promotions should have LocalizedTexts associated
    And All LocalizedTexts should have ar and en values associated
    And All ProgramType should be either episode or movie or series or season
#    Additional Tests I consider that need to be added in extra are implemented below
    And All image url should be in https url and jpeg or png format
    And All image width should be in valid integer format
    And All image height should be in valid integer format
    And All image url should be in https width x height format


  Scenario: Try to Get promotions using invalid API key
    Given I have a invalid API key
    When I access promotions endpoint
    Then HTTP Status code 403 should be provided to the user
    And Error details should be displayed to the user
    And Error should have a RequestId that is not null
    And Error should have a "code" to be "8001"
    And Error should have a "message" to be "invalid api key"