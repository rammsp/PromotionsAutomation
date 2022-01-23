package com.popcorn.promotions.utils;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Promotions.feature",
        glue = "com.popcorn.promotions.stepdefinitions",
        plugin = { "pretty",
                "html:target/cucumber-reports/html/Cucumber.html",
                "json:target/cucumber-reports/json/Cucumber.json",
                "junit:target/cucumber-reports/xml/Cucumber.xml",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm"})
public class TestRunner {
}
