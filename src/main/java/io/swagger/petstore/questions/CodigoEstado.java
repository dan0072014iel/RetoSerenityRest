package io.swagger.petstore.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class CodigoEstado implements Question<Boolean> {


  //se obtiene el codigo  del ultimo response y se guarda para luego compararlo en stepDefinitions
  private final String codigoExpectativa;

  public CodigoEstado(String codigoExpectativa) {
    this.codigoExpectativa = codigoExpectativa;
  }

  public static CodigoEstado delServicio(String codigoExpectativa) {
    return new CodigoEstado(codigoExpectativa);
  }

  @Override
  public Boolean answeredBy(Actor actor) {
    return String.valueOf(SerenityRest.lastResponse().statusCode()).equals(codigoExpectativa);
  }
}
