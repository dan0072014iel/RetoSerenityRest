package io.swagger.petstore.tasks.put;

import io.restassured.response.Response;
import lombok.SneakyThrows;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

import static io.swagger.petstore.utils.Constants.*;

public class PutMascotaRest implements Interaction {

  @SneakyThrows
  @Override
  public <T extends Actor> void performAs(T actor) {
    String jsonTemplate = readJsonFromFile("src/main/java/io/swagger/petstore/tasks/put/RequestPut.json");
    final String json = jsonTemplate.replace("\"id\": 0", "\"id\": " + actor.recall("generatedId"));
    actor.attemptsTo(
        Put.to(ENDPOINT_PET)
            .with(
                request ->
                    request
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .body(json)));
    Response lastResponse = SerenityRest.lastResponse();
    String response = lastResponse.asString();
    logger.info(response);
  }

  public static Performable on() {
    return Instrumented.instanceOf(PutMascotaRest.class).withProperties();
  }
}
