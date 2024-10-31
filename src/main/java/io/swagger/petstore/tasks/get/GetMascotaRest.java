package io.swagger.petstore.tasks.get;

import io.restassured.response.Response;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static io.swagger.petstore.utils.Constants.ENDPOINT_PET;
import static io.swagger.petstore.utils.Constants.logger;

public class GetMascotaRest implements Interaction {

  @Override
  public <T extends Actor> void performAs(T actor) {
    actor.attemptsTo(
        Get.resource(ENDPOINT_PET + actor.recall("generatedId"))
            .with(
                request ->
                    request.header("Content-Type", "application/json").header("Accept", "*/*")));
    Response lastResponse = SerenityRest.lastResponse();
    String response = lastResponse.asString();
    logger.info(response);
  }

  public static Performable on() {
    return Instrumented.instanceOf(GetMascotaRest.class).withProperties();
  }
}