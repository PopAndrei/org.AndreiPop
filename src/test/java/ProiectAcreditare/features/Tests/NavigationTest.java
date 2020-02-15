package ProiectAcreditare.features.Tests;

import ProiectAcreditare.steps.serenity.LogInSteps;
import ProiectAcreditare.steps.serenity.ShopSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

@RunWith(SerenityRunner.class)
public class NavigationTest {

    @Managed(uniqueSession = true)
    private WebDriver driver;

    public void maxWin(){
        driver.manage().window().maximize();
    }

    @Steps
    LogInSteps logInSteps;

    @Steps
    ShopSteps shopSteps;

    @Test
    public void logoTest(){
        logInSteps.navigateToHomepage();
        shopSteps.navigateToShopPage();
        shopSteps.clickOnProduct27();
        logInSteps.clickLogo();
        logInSteps.checkDashBoardMessage("Hello world!");
    }

//    @Test
//    public void headerMenuNavigationTest(){
//
//    }

}
