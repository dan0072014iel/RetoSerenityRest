package io.swagger.petstore.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/PetStoreRest.feature",
    glue = "io.swagger.petstore.stepdefinitions",
    snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "",
        plugin = {"summary", "pretty", "html:target/cucumber-reports"})
public class PetStoreRestRunner {}
