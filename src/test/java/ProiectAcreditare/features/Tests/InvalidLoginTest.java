package ProiectAcreditare.features.Tests;


import ProiectAcreditare.steps.serenity.LogInSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class InvalidLoginTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    @Steps
    private LogInSteps logInSteps;

    @Test
    public void invalidLoginTest(){
        logInSteps.navigateToHomepage();
        logInSteps.goToLogin();
        logInSteps.enterInvalidCredentials("stan_frostmorn@yahoo.com", "FASTTRACKI");
        logInSteps.clickLoginButton();
        logInSteps.checkLoginErrorMessage("ERROR");
        logInSteps.checkLostYourPasswordQuestion("Lost your password?");
    }


}
