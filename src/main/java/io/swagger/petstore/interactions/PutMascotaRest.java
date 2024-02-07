package io.swagger.petstore.interactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutMascotaRest implements Interaction {

  // dentro del body se coloca "PostMascotaRest.getId()",
  // para utilizar la id (ya generado aleatoriamente) que se uso en el post y actualizar la mascota que se creo.
  @Override
  public <T extends Actor> void performAs(T actor) {
    String json =
        "{\n"
            + "  \"id\": "
            + PostMascotaRest.getId()
            + ",\n"
            + "  \"category\": {\n"
            + "    \"id\": "
            + PostMascotaRest.getId()
            + ",\n"
            + "    \"name\": \"lucas\"\n"
            + "  },\n"
            + "  \"name\": \"lucas\",\n"
            + "  \"photoUrls\": [\n"
            + "    \"string\"\n"
            + "  ],\n"
            + "  \"tags\": [\n"
            + "    {\n"
            + "      \"id\": "
            + PostMascotaRest.getId()
            + ",\n"
            + "      \"name\": \"lucas\"\n"
            + "    }\n"
            + "  ],\n"
            + "  \"status\": \"available\"\n"
            + "}";
    actor.attemptsTo(
        Put.to("v2/pet")
            .with(
                request ->
                    request
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .body(json)));
    System.out.println(SerenityRest.lastResponse().asString());
  }

  public static Performable on() {
    return Instrumented.instanceOf(PutMascotaRest.class).withProperties();
  }
}
