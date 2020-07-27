package serenity.tests;

import io.restassured.response.Response;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import serenity.steps.ApiSteps;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

@RunWith(SerenityRunner.class)
public class ApiTest {

    @Steps
    ApiSteps apiSteps;

    @Test
    public void check_json(){
        Response response = apiSteps.getJson();
        response.then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("application/json")
                .body("slideshow.author", equalTo("Yours Truly"))
                .body("slideshow.slides", hasSize(2));
    }

    @Test
    public void check_get_image(){
        Response response = apiSteps.getImage();
        response.then()
                .log()
                .all()
                .assertThat()
                .statusCode(200)
                .contentType("image/png");
    }
}