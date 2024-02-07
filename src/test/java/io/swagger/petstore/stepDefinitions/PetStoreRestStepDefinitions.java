package io.swagger.petstore.stepDefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import io.swagger.petstore.interactions.DeleteMascotaRest;
import io.swagger.petstore.interactions.GetMascotaRest;
import io.swagger.petstore.interactions.PostMascotaRest;
import io.swagger.petstore.interactions.PutMascotaRest;
import io.swagger.petstore.questions.CodigoEstado;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

public class PetStoreRestStepDefinitions {

  @Before
  public void before() {
    OnStage.setTheStage(new OnlineCast());
  }

  @Given("^que me encuentro con la url de Pet store$")
  public void queMeEncuentroConLaUrlDePetStore() {
    // se utiliza la url de la API
    OnStage.theActorCalled("user").whoCan(CallAnApi.at("https://petstore.swagger.io/"));
  }

  @When("^realice el crud de los servicios relacionados a mascota$")
  public void realiceElCrudDeLosServiciosRelacionadosAMascota() {
    // se realiza la ejecucion de las interacciones mencionadas.
    OnStage.theActorInTheSpotlight()
        .attemptsTo(
            PostMascotaRest.on(),
            GetMascotaRest.on(),
            GetMascotaRest.on(),
            PutMascotaRest.on(),
            GetMascotaRest.on(),
            GetMascotaRest.on(),
            DeleteMascotaRest.on());
  }

  @Then("^validare que el codigo de estado del servicio final sea (\\d+)$")
  public void validareQueElCodigoDeEstadoDelServicioFinalSea(String estado) {
    // se realiza la validacion en el que el codigo de respuesta sea el correcto
    OnStage.theActorInTheSpotlight()
        .should(GivenWhenThen.seeThat(CodigoEstado.delServicio(estado)));
  }
}
