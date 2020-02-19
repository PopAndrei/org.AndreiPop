package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.NavigationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Step;
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

    @Steps
    private NavigationSteps navigationSteps;

    private String email = "stan_frostmorn@yahoo.com";
    private String pass = "fasttracki";


    @Test
    public void registerTest(){
        navigationSteps.navigateToHomepage();
        navigationSteps.clickOnMyAccountMenuButton();
        String randomlyGeneratedEmail = logInSteps.generateRandomValidEmail();
        logInSteps.inputRegisterEmail(randomlyGeneratedEmail);
        logInSteps.inputRegisterPassword();
        logInSteps.clickOnRegisterButton();
        String nameOfRegisteredEmail = logInSteps.getNameToCheck(randomlyGeneratedEmail);
        logInSteps.checkLoggedIn(nameOfRegisteredEmail);
    }

    @Test
    public void validLoginTest(){
        logInSteps.navigateToHomepage();
        logInSteps.goToLogin();
        logInSteps.enterCredentials(email,pass);
        logInSteps.clickLoginButton();
        logInSteps.checkLoggedIn("stan_frostmorn");
    }


    @Test
    public void invalidLoginTest(){
        logInSteps.navigateToHomepage();
        logInSteps.goToLogin();
        logInSteps.enterInvalidCredentials(email,pass);
        logInSteps.clickLoginButton();
        logInSteps.checkIfErrorMessageVisible();
        logInSteps.checkLostYourPasswordQuestion("Lost your password?");
    }


    @Test
    public void logOutTest(){
        logInSteps.navigateToHomepage();
        logInSteps.login(email,pass);
        logInSteps.clickLogOutButton();
        logInSteps.checkDashBoardMessage("Hello world!");

    }


}
