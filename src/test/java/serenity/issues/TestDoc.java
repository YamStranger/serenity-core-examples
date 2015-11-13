package serenity.issues;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * User: YamStranger
 * Date: 10/26/2015
 * Time: 12:01 PM
 */
@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value = "status-levels.csv")
public class TestDoc {

    private int kilometersTravelled;

    public void setKilometersTravelled(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    @Qualifier
    public String qualifier() {
        return "" + kilometersTravelled;
    }

    @Steps
    TravellerSteps travellerSteps;

    @Test
    public void reallyhouldEarnNextStatusWithEnoughPoints() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(kilometersTravelled);
    }
}