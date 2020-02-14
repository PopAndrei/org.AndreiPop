package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.LogInSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class LogoutTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    public void makeWindowBIG(){
        driver.manage().window().maximize();
    }

    @Steps
    LogInSteps logInSteps;

    @Test
    public void logOutTest(){
        logInSteps.navigateToHomepage();
        logInSteps.login("stan_frostmorn@yahoo.com","fasttracki");
        logInSteps.clickLogOutButton();
        logInSteps.checkDashBoardMessage("Hello world!");

    }
}
