package io.swagger.petstore.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.swagger.petstore.interactions.RandomId;
import io.swagger.petstore.tasks.delete.DeleteMascotaRest;
import io.swagger.petstore.tasks.get.GetMascotaRest;
import io.swagger.petstore.tasks.post.PostMascotaRest;
import io.swagger.petstore.tasks.put.PutMascotaRest;
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
        OnStage.theActorCalled("Daniel").whoCan(CallAnApi.at("https://petstore.swagger.io/"));
    }

    @When("^realice el crud de los servicios relacionados a mascota$")
    public void realiceElCrudDeLosServiciosRelacionadosAMascota() {
        OnStage.theActorInTheSpotlight()
                .attemptsTo(
                        RandomId.on(),
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
        OnStage.theActorInTheSpotlight()
                .should(GivenWhenThen.seeThat(CodigoEstado.delServicio(estado)));
    }
}
