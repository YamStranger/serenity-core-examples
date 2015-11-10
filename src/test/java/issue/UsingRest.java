package issue;

import net.thucydides.core.annotations.Step;
import com.jayway.restassured.http.ContentType;
import net.serenitybdd.core.rest.RestQuery;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.model.TestResult;
import net.thucydides.core.steps.BaseStepListener;
import net.thucydides.core.steps.StepEventBus;
import net.thucydides.core.steps.StepFactory;
import org.junit.Rule;
import org.junit.rules.TemporaryFolder;

import static com.jayway.restassured.RestAssured.given;;
import static net.serenitybdd.core.rest.RestMethod.*;
import static net.serenitybdd.rest.SerenityRest.then;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
/**
 * User: YamStranger
 * Date: 11/10/15
 * Time: 7:18 PM
 */
public class UsingRest {
    @Step
    public void usingRest(){
        rest().given()
            .contentType("application/json")
            .content(jsonPet)
            .post("http://petstore.swagger.io/v2/pet");
    }
}
