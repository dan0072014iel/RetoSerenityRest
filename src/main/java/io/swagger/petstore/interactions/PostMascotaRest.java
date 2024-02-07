package io.swagger.petstore.interactions;

import java.util.Random;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostMascotaRest implements Interaction {

  private static int id = generateRandomId();

  private static int generateRandomId() {
    Random random = new Random();
    int min = 100, max = 110, range = max - min + 1;
    return random.nextInt(range) + min;
  }

  public static int getId() {
    return id;
  }

  @Override
  public <T extends Actor> void performAs(T actor) {
    String json =
        "{\n"
            + "  \"id\": "
            + id
            + ",\n"
            + "  \"category\": {\n"
            + "    \"id\": "
            + id
            + ",\n"
            + "    \"name\": \"firulais\"\n"
            + "  },\n"
            + "  \"name\": \"firulais\",\n"
            + "  \"photoUrls\": [\n"
            + "    \"string\"\n"
            + "  ],\n"
            + "  \"tags\": [\n"
            + "    {\n"
            + "      \"id\": "
            + id
            + ",\n"
            + "      \"name\": \"firulais\"\n"
            + "    }\n"
            + "  ],\n"
            + "  \"status\": \"available\"\n"
            + "}";
    actor.attemptsTo(
        Post.to("v2/pet")
            .with(
                request ->
                    request
                        .header("Content-Type", "application/json")
                        .header("Accept", "*/*")
                        .body(json)));
    System.out.println(SerenityRest.lastResponse().asString());
  }

  public static Performable on() {
    return Instrumented.instanceOf(PostMascotaRest.class).withProperties();
  }
}
