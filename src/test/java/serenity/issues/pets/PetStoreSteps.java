package serenity.issues.pets;

import com.jayway.restassured.RestAssured;
import net.thucydides.core.annotations.Step;
import org.mockito.internal.matchers.Contains;

import java.util.Random;

import static net.serenitybdd.rest.SerenityRest.rest;
import static org.hamcrest.Matchers.*;

/**
 * Created by john on 3/06/2015.
 */
public class PetStoreSteps {

    Pet pet;

    @Step
    public void when_i_add_the_pet_to_the_store(Pet pet) {
        this.pet = pet;
        int id = /*Math.abs(new Random().nextInt());*/6851654;
        String jsonPet = "{\"id\": " + id + " , \"name\": \""
                + pet.getName() + "\", \"photoUrls\": [], \"status\": \""
                + pet.getStatus() + "\"}";

        rest().given().contentType("application/json")
                .content(jsonPet).post("http://petstore.swagger.io/v2/pet");

        this.pet.setId(id);
    }

    @Step
    public void the_pets_should_be_available() {
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
                    .then().statusCode(200)
                    .and().body("name", equalTo(pet.getName()));
    }


    @Step
    public void when_i_delete_the_pet() {
        rest().delete("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
            .then().statusCode(200)
            .and().body("name", equalTo(pet.getName()));
    }
    @Step
    public void the_pets_should_be_not_available() {
        rest().get("http://petstore.swagger.io/v2/pet/{id}", pet.getId())
            .then().statusCode(200)
            .and().body(containsString("NotFound"));
    }



    @Step
    public void issue_step(){
        /*rest().given().contentType("application/json").
        get("https://api.github.com/repos/serenity-bdd/serenity-core")
            .then().assertThat().body(containsString("OK"));*/
/*        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.given().get("https://api.github.com/repos/serenity-bdd/serenity-core")
            .then().statusCode(200).and().body("id", equalTo(26201720));*/


        rest().given().relaxedHTTPSValidation()
            .when()
            .get("https://api.github.com/repos/serenity-bdd/serenity-core")
            .then().statusCode(200)
            .and().body("id", equalTo(26201720));
    }
}
