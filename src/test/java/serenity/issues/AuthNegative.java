package serenity.issues;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("AuthNegative.csv")
public class AuthNegative {

    @Managed
    public WebDriver driver;

    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Qualifier
    public String qualifier() {
        return "incorrect number " + phone;
    }

    @Steps
    AuthorizationSteps steps;

    @Test
    public void negativeAuthorizeWithPhone() {
        steps.authorizeWithPhone(this.phone);
    }
}


