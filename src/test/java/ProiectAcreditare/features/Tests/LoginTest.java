package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.LogInSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LoginTest {

    @Managed (uniqueSession = true)
    private WebDriver driver;

    @Before
    public void maximiseWindow(){
        driver.manage().window().maximize();
    }

    @Steps
    private LogInSteps logInSteps;


    @Test
    public void validLoginTest(){
        logInSteps.navigateToHomepage();
        logInSteps.goToLogin();
        logInSteps.enterCredentials("stan_frostmorn@yahoo.com","fasttracki");
        logInSteps.clickLoginButton();
        logInSteps.checkLoggedIn("stan_frostmorn");
    }


    @Test
    public void invalidLoginTest(){
        logInSteps.navigateToHomepage();
        logInSteps.goToLogin();
        logInSteps.enterInvalidCredentials("stan_frostmorn@yahoo.com", "FASTTRACKI");
        logInSteps.clickLoginButton();
        logInSteps.checkIfErrorMessageVisible();
        logInSteps.checkLostYourPasswordQuestion("Lost your password?");
    }


    @Test
    public void logOutTest(){
        logInSteps.navigateToHomepage();
        logInSteps.login("stan_frostmorn@yahoo.com","fasttracki");
        logInSteps.clickLogOutButton();
        logInSteps.checkDashBoardMessage("Hello world!");

    }


}
