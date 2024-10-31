package io.swagger.petstore.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;

import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RandomId implements Interaction {

    private static final Random random = new Random();

    @Override
    public <T extends Actor> void performAs(T actor) {
        int id;
        int min = 100;
        int max = 110;
        int range = max - min + 1;
        id = random.nextInt(range) + min;
        actor.remember("generatedId", id);
    }

    public static Performable on() {
        return instrumented(RandomId.class);
    }
}
