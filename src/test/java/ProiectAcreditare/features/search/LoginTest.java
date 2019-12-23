package ProiectAcreditare.features.search;

import ProiectAcreditare.steps.serenity.LogInSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed (uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LogInSteps logInSteps;

    @Test
    public void validLoginTest(){
        logInSteps.navigateToHomepage();
        logInSteps.goToLogin();
        logInSteps.enterCredentials("cosmin@fasttrackit.org","123456");
        logInSteps.clickLogin();
        logInSteps.checkLoggedIn("Hello, Hai C' Am Schimbat La Loc (Merry Christams)!");
    }

}
