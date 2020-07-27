package serenity.steps;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class ApiSteps extends ScenarioSteps {

    @Step
    public Response getJson(){
        return SerenityRest.given()
                .baseUri("https://httpbin.org")
                .log()
                .all()
                .get("/json");
    }
    public Response getImage(){
        return SerenityRest.given()
                .baseUri("https://httpbin.org")
                .log()
                .all()
                .get("/image/png");
    }
}