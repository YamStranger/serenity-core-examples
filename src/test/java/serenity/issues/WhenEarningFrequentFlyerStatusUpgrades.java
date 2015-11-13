package serenity.issues;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

/**
 * User: YamStranger
 * Date: 10/26/2015
 * Time: 12:47 PM
 */
@RunWith(SerenityParameterizedRunner.class)
public class WhenEarningFrequentFlyerStatusUpgrades {

    @Managed
    public WebDriver driver;

    @TestData
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
            {0},
            {9999},
            {10000},
            {49999},
            {50000}
        });
    }

    private final int kilometersTravelled;

    public WhenEarningFrequentFlyerStatusUpgrades(int kilometersTravelled) {
        this.kilometersTravelled = kilometersTravelled;
    }

    @Steps
    TravellerSteps travellerSteps;

    @Test
    public void shouldEarnNextStatusWithEnoughPoints() {
        // GIVEN
        travellerSteps.a_traveller_joins_the_frequent_flyer_program();

        // WHEN
        travellerSteps.the_traveller_flies(kilometersTravelled);
    }
}